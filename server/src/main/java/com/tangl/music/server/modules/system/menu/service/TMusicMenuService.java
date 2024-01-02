package com.tangl.music.server.modules.system.menu.service;

import com.tangl.music.server.modules.system.menu.context.AddMenuContext;
import com.tangl.music.server.modules.system.menu.context.DeleteMenuContext;
import com.tangl.music.server.modules.system.menu.context.QueryMenuContext;
import com.tangl.music.server.modules.system.menu.context.UpdateMenuContext;
import com.tangl.music.server.modules.system.menu.entity.TMusicMenu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author tangl
 * @description 菜单业务层
 * @create 2023-12-21 23:23:26
 */
public interface TMusicMenuService extends IService<TMusicMenu> {

    /**
     * 新增菜单
     *
     * @param context 上下文实体
     */
    void add(AddMenuContext context);

    /**
     * 删除菜单
     *
     * @param context 上下文实体
     */
    void delete(DeleteMenuContext context);

    /**
     * 更新菜单
     *
     * @param context 上下文实体
     */
    void update(UpdateMenuContext context);

    /**
     * 查询菜单
     *
     * @param context 上下文实体
     */
    void queryPage(QueryMenuContext context);
}
