package com.tangl.music.server.modules.system.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tangl.music.server.modules.system.user.context.QueryUserContext;
import com.tangl.music.server.modules.system.user.entity.TMusicUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tangl
 * @description 针对表【t_music_user】的数据库操作 Mapper
 * @create 2023-12-21 23:27:58
 */
public interface TMusicUserMapper extends BaseMapper<TMusicUser> {

    /**
     * 更新用户信息
     *
     * @param user 用户实体
     * @return 受影响行数
     */
    Integer updateUser(TMusicUser user);

    /**
     * 根据条件查询行数
     *
     * @param context 上下文实体
     * @return 行数
     */
    Long count(QueryUserContext context);

    /**
     * 分页条件查询
     *
     * @param context  上下文实体
     * @param offset   偏移量
     * @param pageSize 页面大小
     * @return 用户记录列表
     */
    List<TMusicUser> queryPage(@Param("params") QueryUserContext context,
                               @Param("offset") Integer offset,
                               @Param("pageSize") Integer pageSize);
}
