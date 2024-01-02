package com.tangl.music.server.security.handler;

import com.tangl.music.core.exception.TMusicBusinessException;
import com.tangl.music.server.common.enums.DelFlagEnum;
import com.tangl.music.server.common.enums.UserStatusEnum;
import com.tangl.music.server.modules.system.role.context.QueryPermissionsContext;
import com.tangl.music.server.modules.system.role.service.TMusicRoleMenuService;
import com.tangl.music.server.modules.system.role.vo.RoleVO;
import com.tangl.music.server.modules.system.user.service.TMusicUserService;
import com.tangl.music.server.modules.system.user.vo.UserVO;
import com.tangl.music.server.security.constants.SecurityConstants;
import com.tangl.music.server.security.entity.LoginUser;
import com.tangl.music.server.security.service.PasswordService;
import com.tangl.music.server.security.utils.SecurityUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author tangl
 * @description 用户验证处理
 * @create 2023-12-25 21:43
 */
@Component
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private TMusicUserService userService;

    @Resource
    private PasswordService passwordService;

    @Resource
    private TMusicRoleMenuService roleMenuService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVO user = userService.queryUserByUsername(username);
        if (Objects.isNull(user)) {
            log.info("登录用户：{} 不存在.", username);
            throw new TMusicBusinessException("用户名或密码错误");
        } else if (DelFlagEnum.YES.getCode().equals(user.getDelFlag())) {
            log.info("登录用户：{} 已被删除.", username);
            throw new TMusicBusinessException("账号已删除");
        } else if (UserStatusEnum.DISABLE.getCode().equals(user.getStatus())) {
            log.info("登录用户：{} 已被停用.", username);
            throw new TMusicBusinessException("账号已禁用");
        }
        // 验证账号密码
        passwordService.validate(user);
        return createLoginUser(user);
    }

    private UserDetails createLoginUser(UserVO user) {
        return new LoginUser(user.getUserId(), user, getMenuPermission(user));
    }

    /**
     * 获取菜单权限标识
     *
     * @param user 用户实体
     * @return 权限标识
     */
    private Set<String> getMenuPermission(UserVO user) {
        HashSet<String> permissions = new HashSet<>();
        List<RoleVO> roleList = user.getRoleList();

        // 是否是超级管理员
        if (CollectionUtils.isNotEmpty(roleList)) {
            if (SecurityUtils.isSuperAdmin(roleList)) {
                permissions.add(SecurityConstants.ALL_PERMISSION);
            }
        }

        // 根据角色ID查询权限列表
        if (!permissions.contains(SecurityConstants.ALL_PERMISSION)) {
            List<Long> roleIdList = roleList.stream().map(RoleVO::getRoleId).toList();
            QueryPermissionsContext context = new QueryPermissionsContext();
            context.setRoleIdList(roleIdList);
            List<String> rolePermissions = roleMenuService.queryPermissions(context);
            permissions.addAll(rolePermissions);
        }
        return permissions;
    }
}
