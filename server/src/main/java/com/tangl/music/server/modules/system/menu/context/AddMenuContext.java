package com.tangl.music.server.modules.system.menu.context;

import com.tangl.music.server.modules.system.menu.entity.TMusicMenu;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tangl
 * @description 新增菜单上下文实体
 * @create 2023-12-24 9:24
 */
@Data
public class AddMenuContext implements Serializable {

    private static final long serialVersionUID = -166521037155493139L;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 父级菜单ID
     */
    private Long parentId;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 菜单路径
     */
    private String component;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 菜单类型
     */
    private Integer menuType;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 显示顺序
     */
    private Integer orderNum;

    /**
     * 菜单实体
     */
    private TMusicMenu entity;
}
