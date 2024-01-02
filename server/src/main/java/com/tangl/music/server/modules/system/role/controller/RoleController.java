package com.tangl.music.server.modules.system.role.controller;

import com.google.common.base.Splitter;
import com.tangl.music.core.constants.TMusicConstants;
import com.tangl.music.core.exception.TMusicBusinessException;
import com.tangl.music.core.response.R;
import com.tangl.music.core.utils.IdUtil;
import com.tangl.music.server.common.page.PageResult;
import com.tangl.music.server.modules.system.role.context.*;
import com.tangl.music.server.modules.system.role.converter.RoleConverter;
import com.tangl.music.server.modules.system.role.po.*;
import com.tangl.music.server.modules.system.role.service.TMusicRoleMenuService;
import com.tangl.music.server.modules.system.role.service.TMusicRoleService;
import com.tangl.music.server.modules.system.role.vo.RoleVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotBlank;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tangl
 * @description 角色模块控制器
 * @create 2023-12-22 0:00
 */
@Tag(name = "角色模块")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    RoleConverter converter;

    @Resource
    private TMusicRoleService roleService;

    @Resource
    private TMusicRoleMenuService roleMenuService;

    @Operation(summary = "新增角色", description = "该接口提供了新增角色的功能")
    @PostMapping("add")
    public R<?> add(@Validated @RequestBody AddRolePO addRolePO) {
        AddRoleContext context = converter.addRolePO2AddRoleContext(addRolePO);
        roleService.add(context);
        return R.success();
    }

    @Operation(summary = "删除角色", description = "该接口提供了删除角色的功能")
    @DeleteMapping("delete")
    public R<?> delete(@Validated @RequestBody DeleteRolePO deleteRolePO) {
        DeleteRoleContext context = converter.deleteRolePO2DeleteRoleContext(deleteRolePO);
        roleService.delete(context);
        return R.success();
    }

    @Operation(summary = "更新角色", description = "该接口提供了更新角色的功能")
    @PutMapping("update")
    public R<?> update(@Validated @RequestBody UpdateRolePO updateRolePO) {
        UpdateRoleContext context = converter.updateRolePO2UpdateRoleContext(updateRolePO);
        roleService.update(context);
        return R.success();
    }

    @Operation(summary = "查询角色", description = "该接口提供了查询角色的功能")
    @PostMapping("query")
    public R<PageResult<RoleVO>> query(@Validated @RequestBody QueryRolePO queryRolePO) {
        QueryRoleContext context = converter.queryRolePO2QueryRoleContext(queryRolePO);
        PageResult<RoleVO> pageResult = context.getPageResult();
        pageResult.setPageNo(queryRolePO.getPageNo());
        pageResult.setPageSize(queryRolePO.getPageSize());
        // 分页条件查询角色列表
        roleService.queryPage(context);
        return R.data(pageResult);
    }

    @Operation(summary = "分配角色权限", description = "该接口提供了分配角色权限的功能")
    @PostMapping("assignPermissions")
    public R<?> assignPermissions(@Validated @RequestBody AssignPermissionsPO assignPermissionsPO) {
        AssignPermissionsContext context = converter.assignPermissionsPO2AssignPermissionsContext(assignPermissionsPO);
        String menuIds = assignPermissionsPO.getMenuIds();
        if (StringUtils.isNotBlank(menuIds)) {
            List<Long> menuIdList = Splitter.on(TMusicConstants.COMMON_SEPARATOR)
                    .splitToList(menuIds)
                    .stream().map(IdUtil::decrypt).collect(Collectors.toList());
            context.setMenuIds(menuIdList);
        }
        roleMenuService.assignPermissions(context);
        return R.success();
    }

    @Operation(summary = "查询权限", description = "该接口提供了查询权限的功能")
    @GetMapping("permissions")
    public R<List<String>> queryPermissions(@Validated @NotBlank(message = "角色ID不能为空")
                                            @RequestParam(value = "roleIds", required = false) String roleIds) {
        List<Long> roleIdList = Splitter.on(TMusicConstants.COMMON_SEPARATOR)
                .splitToList(roleIds)
                .stream()
                .map(IdUtil::decrypt)
                .toList();
        if (CollectionUtils.isEmpty(roleIdList)) {
            throw new TMusicBusinessException("无效的角色ID");
        }
        QueryPermissionsContext context = new QueryPermissionsContext();
        context.setRoleIdList(roleIdList);
        List<String> permissions = roleMenuService.queryPermissions(context);
        return R.data(permissions);
    }
}
