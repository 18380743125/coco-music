package com.tangl.music.server.modules.system.role.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tangl.music.server.modules.system.role.context.QueryRoleContext;
import com.tangl.music.server.modules.system.role.entity.TMusicRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tangl
 * @description 针对表【t_music_role】的数据库操作 Mapper
 * @create 2023-12-21 23:23:26
 */
public interface TMusicRoleMapper extends BaseMapper<TMusicRole> {

    /**
     * 更新角色信息
     *
     * @param role 角色实体
     * @return 受影响行数
     */
    Integer updateRole(TMusicRole role);

    /**
     * 根据条件统计总行数
     *
     * @param context 上下文实体
     * @return 行数
     */
    Long count(QueryRoleContext context);

    /**
     * 分页条件查询
     *
     * @param context  上下文实体
     * @param offset   偏移量
     * @param pageSize 页面大小
     * @return 角色列表
     */
    List<TMusicRole> queryPage(@Param("params") QueryRoleContext context,
                               @Param("offset") Integer offset,
                               @Param("pageSize") Integer pageSize);

    /**
     * 根据角色ID查询
     *
     * @param roleIdList 角色ID列表
     * @return 角色列表
     */
    List<TMusicRole> queryByIdList(@Param("roleIdList") List<Long> roleIdList);
}
