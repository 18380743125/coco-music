package com.tangl.music.server.modules.system.role.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tangl.music.server.modules.system.role.context.AddRoleContext;
import com.tangl.music.server.modules.system.role.context.DeleteRoleContext;
import com.tangl.music.server.modules.system.role.context.QueryRoleContext;
import com.tangl.music.server.modules.system.role.context.UpdateRoleContext;
import com.tangl.music.server.modules.system.role.entity.TMusicRole;

import java.util.List;

/**
 * @author tangl
 * @description 角色业务层
 * @create 2023-12-21 23:23:27
 */
public interface TMusicRoleService extends IService<TMusicRole> {

    /**
     * 新增角色
     *
     * @param context 上下文实体
     */
    void add(AddRoleContext context);

    /**
     * 删除角色
     *
     * @param context 上下文实体
     */
    void delete(DeleteRoleContext context);

    /**
     * 更新角色
     *
     * @param context 上下文实体
     */
    void update(UpdateRoleContext context);

    /**
     * 查询角色
     *
     * @param context 上下文实体
     */
    void queryPage(QueryRoleContext context);

    /**
     * 根据角色ID列表查询
     *
     * @param roleIdList 角色ID列表
     * @return 角色列表
     */
    List<TMusicRole> queryByIdList(List<Long> roleIdList);
}
