package com.tangl.music.server.modules.system.menu.context;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tangl
 * @description 更新菜单上下文实体
 * @create 2023-12-24 9:38
 */
@Data
public class UpdateMenuContext implements Serializable {

    private static final long serialVersionUID = -4807745511378420983L;

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 父级菜单ID
     */
    private Long parentId;

    /**
     * 路径地址
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
     * 菜单状态
     */
    private Integer status;
}
