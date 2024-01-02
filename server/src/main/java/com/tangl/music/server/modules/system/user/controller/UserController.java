package com.tangl.music.server.modules.system.user.controller;

import com.google.common.base.Splitter;
import com.tangl.music.core.constants.TMusicConstants;
import com.tangl.music.core.exception.TMusicBusinessException;
import com.tangl.music.core.response.R;
import com.tangl.music.core.utils.IdUtil;
import com.tangl.music.server.common.page.PageResult;
import com.tangl.music.server.modules.system.user.context.*;
import com.tangl.music.server.modules.system.user.converter.UserConverter;
import com.tangl.music.server.modules.system.user.po.*;
import com.tangl.music.server.modules.system.user.service.TMusicUserRoleService;
import com.tangl.music.server.modules.system.user.service.TMusicUserService;
import com.tangl.music.server.modules.system.user.vo.UserVO;
import com.tangl.music.server.security.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangl
 * @description 用户模块控制器
 * @create 2023-12-22 0:00
 */
@Tag(name = "用户模块")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserConverter converter;

    @Resource
    private TMusicUserService userService;

    @Resource
    private TMusicUserRoleService userRoleService;

    @Resource
    private LoginService loginService;

    @Operation(summary = "注册用户", description = "该接口提供了注册用户的功能")
    @PostMapping("/register")
    public R<String> register(@Validated @RequestBody RegisterUserPO registerUserPO) {
        RegisterUserContext context = converter.registerUserPO2RegisterUserContext(registerUserPO);
        List<String> roleNameList = new ArrayList<>(Splitter.on(TMusicConstants.COMMON_SEPARATOR)
                .splitToList(registerUserPO.getRoleNames()));
        if (CollectionUtils.isEmpty(roleNameList)) {
            throw new TMusicBusinessException("角色名称不能为空");
        }
        context.setRoleNameList(roleNameList);
        Long userId = userService.register(context);
        return R.data(IdUtil.encrypt(userId));
    }

    @PostMapping("/login")
    @Operation(summary = "用户登录", description = "该接口提供了用户登录的功能")
    public R<String> login(@Validated @RequestBody UserLoginPO userLoginPO) {
        UserLoginContext context = converter.userLoginPO2UserLoginContext(userLoginPO);
        String token = loginService.login(context);
        return R.data(token);
    }

    @Operation(summary = "删除用户", description = "该接口提供了删除用户的功能")
    @DeleteMapping("/delete")
    public R<?> delete(@Validated @RequestBody DeleteUserPO deleteUserPO) {
        DeleteUserContext context = converter.deleteUserPO2DeleteUserContext(deleteUserPO);
        userService.delete(context);
        return R.success();
    }

    @PutMapping("/update")
    @Operation(summary = "更新用户", description = "该接口提供了更新用户的功能")
    public R<?> update(@Validated @RequestBody UpdateUserPO updateUserPO) {
        UpdateUserContext context = converter.updateUserPO2UpdateUserContext(updateUserPO);
        userService.update(context);
        return R.success();
    }

    // @PreAuthorize("@ss.hasPerm('system:user@query')")
    @PostMapping("/query")
    @Operation(summary = "查询用户", description = "该接口提供了查询用户的功能")
    public R<PageResult<UserVO>> query(@Validated @RequestBody QueryUserPO queryUserPO) {
        QueryUserContext context = converter.queryUserPO2QueryUserContext(queryUserPO);
        PageResult<UserVO> pageResult = context.getPageResult();
        pageResult.setPageNo(queryUserPO.getPageNo());
        pageResult.setPageSize(queryUserPO.getPageSize());
        userService.queryPage(context);
        return R.data(pageResult);
    }

    @PutMapping("/changeRole")
    @Operation(summary = "更新用户角色", description = "该接口提供了更新用户角色的功能")
    public R<?> changeRole(@Validated @RequestBody ChangeRolePO changeRolePO) {
        List<Long> roleIdList = Splitter.on(TMusicConstants.COMMON_SEPARATOR)
                .splitToList(changeRolePO.getRoleIds())
                .stream()
                .map(IdUtil::decrypt).toList();
        if (CollectionUtils.isEmpty(roleIdList)) {
            throw new TMusicBusinessException("角色ID不能为空");
        }
        ChangeRoleContext context = new ChangeRoleContext();
        context.setRoleIdList(roleIdList);
        context.setUserId(IdUtil.decrypt(changeRolePO.getUserId()));
        userRoleService.changeRole(context);
        return R.success();
    }
}
