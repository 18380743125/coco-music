package com.tangl.music.server.modules.system.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tangl.music.server.modules.system.role.vo.RoleVO;
import com.tangl.music.server.modules.system.user.context.AddUserRoleContext;
import com.tangl.music.server.modules.system.user.context.ChangeRoleContext;
import com.tangl.music.server.modules.system.user.entity.TMusicUserRole;

import java.util.List;

/**
 * @author tangl
 * @description 用户角色业务层
 * @create 2023-12-21 23:23:27
 */
public interface TMusicUserRoleService extends IService<TMusicUserRole> {

    /**
     * 关联用户角色表
     */
    void add(AddUserRoleContext context);

    /**
     * 更新用户角色
     *
     * @param context 上下文实体
     */
    void changeRole(ChangeRoleContext context);

    /**
     * 根据 userId 查询角色名称
     *
     * @param userId 用户ID
     * @return 角色名称
     */
    List<String> queryRoleNamesById(Long userId);

    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return 角色列表
     */
    List<RoleVO> queryRoleByUserId(Long userId);
}
