package com.tangl.music.server.modules.system.menu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tangl.music.server.modules.system.menu.context.QueryMenuContext;
import com.tangl.music.server.modules.system.menu.entity.TMusicMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tangl
 * @description 针对表【t_music_menu】的数据库操作 Mapper
 * @create 2023-12-21 23:23:26
 */
public interface TMusicMenuMapper extends BaseMapper<TMusicMenu> {

    /**
     * 更新菜单信息
     *
     * @param menu 菜单实体
     * @return 受影响行数
     */
    Integer updateMenu(TMusicMenu menu);

    /**
     * 根据条件统计总行数
     *
     * @param context 上下文实体
     * @return 行数
     */
    Long count(QueryMenuContext context);

    /**
     * 分页条件查询
     *
     * @param context  上下文实体
     * @param offset   偏移量
     * @param pageSize 页面大小
     * @return 菜单列表
     */
    List<TMusicMenu> queryPage(@Param("params") QueryMenuContext context,
                               @Param("offset") Integer offset,
                               @Param("pageSize") Integer pageSize);
}
