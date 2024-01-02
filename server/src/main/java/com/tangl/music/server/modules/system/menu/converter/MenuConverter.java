package com.tangl.music.server.modules.system.menu.converter;

import com.tangl.music.server.modules.system.menu.context.AddMenuContext;
import com.tangl.music.server.modules.system.menu.context.DeleteMenuContext;
import com.tangl.music.server.modules.system.menu.context.QueryMenuContext;
import com.tangl.music.server.modules.system.menu.context.UpdateMenuContext;
import com.tangl.music.server.modules.system.menu.entity.TMusicMenu;
import com.tangl.music.server.modules.system.menu.po.AddMenuPO;
import com.tangl.music.server.modules.system.menu.po.DeleteMenuPO;
import com.tangl.music.server.modules.system.menu.po.QueryMenuPO;
import com.tangl.music.server.modules.system.menu.po.UpdateMenuPO;
import com.tangl.music.server.modules.system.menu.vo.MenuVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author tangl
 * @description
 * @create 2023-12-24 9:26
 */
@Mapper(componentModel = "spring")
public interface MenuConverter {

    @Mapping(target = "parentId", ignore = true)
    AddMenuContext addMenuPO2AddMenuContext(AddMenuPO addMenuPO);

    TMusicMenu addMenuContext2Menu(AddMenuContext context);

    @Mapping(target = "menuId", expression = "java(com.tangl.music.core.utils.IdUtil.decrypt(deleteMenuPO.getMenuId()))")
    DeleteMenuContext deleteMenuPO2DeleteMenuContext(DeleteMenuPO deleteMenuPO);

    @Mapping(target = "parentId", ignore = true)
    @Mapping(target = "menuId", expression = "java(com.tangl.music.core.utils.IdUtil.decrypt(updateMenuPO.getMenuId()))")
    UpdateMenuContext updateMenuPO2UpdateMenuContext(UpdateMenuPO updateMenuPO);

    TMusicMenu updateMenuContext2Menu(UpdateMenuContext context);

    QueryMenuContext queryMenuPO2QueryMenuContext(QueryMenuPO queryMenuPO);

    List<MenuVO> menuList2MenuVOList(List<TMusicMenu> menuList);
}
