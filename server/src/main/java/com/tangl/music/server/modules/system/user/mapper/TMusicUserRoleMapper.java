package com.tangl.music.server.modules.system.user.mapper;

import com.tangl.music.server.modules.system.role.entity.TMusicRole;
import com.tangl.music.server.modules.system.user.entity.TMusicUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tangl
 * @description 针对表【t_music_user_role】的数据库操作 Mapper
 * @create 2023-12-21 23:23:27
 */
public interface TMusicUserRoleMapper extends BaseMapper<TMusicUserRole> {

    /**
     * 根据用户ID查询角色名称
     *
     * @param userId 用户ID
     * @return 角色名称
     */
    List<String> queryRoleNamesById(@Param("userId") Long userId);

    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return 角色列表
     */
    List<TMusicRole> queryRoleByUserId(@Param("userId") Long userId);
}
