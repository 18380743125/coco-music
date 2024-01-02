package com.tangl.music.server.modules.system.role.mapper;

import com.tangl.music.server.modules.system.role.entity.TMusicRoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author tangl
 * @description 针对表【t_music_role_menu】的数据库操作 Mapper
 * @create 2023-12-21 23:23:27
 */
public interface TMusicRoleMenuMapper extends BaseMapper<TMusicRoleMenu> {

    /**
     * 查询权限标识列表
     *
     * @param roleIdList 角色ID列表
     * @return 权限标识列表
     */
    List<String> queryPermissions(List<Long> roleIdList);
}
