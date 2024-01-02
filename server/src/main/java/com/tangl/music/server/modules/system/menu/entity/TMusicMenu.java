package com.tangl.music.server.modules.system.menu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单表
 *
 * @TableName t_music_menu
 */
@TableName(value = "t_music_menu")
@Data
public class TMusicMenu implements Serializable {

    /**
     * 菜单ID
     */
    @TableId(value = "menu_id")
    private Long menuId;

    /**
     * 菜单名称
     */
    @TableField(value = "menu_name")
    private String menuName;

    /**
     * 父级菜单ID
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 路由地址
     */
    @TableField(value = "path")
    private String path;

    /**
     * 菜单路径
     */
    @TableField(value = "component")
    private String component;

    /**
     * 权限标识
     */
    @TableField(value = "permission")
    private String permission;

    /**
     * 菜单类型（0-菜单，1-页面，2-按钮）
     */
    @TableField(value = "menu_type")
    private Integer menuType;

    /**
     * 菜单图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 显示顺序
     */
    @TableField(value = "order_num")
    private Integer orderNum;

    /**
     * 菜单状态（0-正常，1-停用）
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建者
     */
    @TableField(value = "create_by")
    private Long createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新者
     */
    @TableField(value = "update_by")
    private Long updateBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 是否删除（0-未删除，1-已删除）
     */
    @TableField(value = "del_flag")
    private Integer delFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}