package com.tangl.music.server.modules.system.role.service;

import com.tangl.music.server.modules.system.role.context.AssignPermissionsContext;
import com.tangl.music.server.modules.system.role.context.QueryPermissionsContext;
import com.tangl.music.server.modules.system.role.entity.TMusicRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author tangl
 * @description 角色菜单业务层
 * @create 2023-12-21 23:23:27
 */
public interface TMusicRoleMenuService extends IService<TMusicRoleMenu> {

    /**
     * 分配角色权限
     *
     * @param context 上下文实体
     */
    void assignPermissions(AssignPermissionsContext context);

    /**
     * 查询权限
     *
     * @param context 上下文实体
     * @return 权限列表
     */
    List<String> queryPermissions(QueryPermissionsContext context);
}
