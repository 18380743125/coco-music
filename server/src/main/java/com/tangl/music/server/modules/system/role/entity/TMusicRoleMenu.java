package com.tangl.music.server.modules.system.role.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色菜单关联表
 *
 * @TableName t_music_role_menu
 */
@TableName(value = "t_music_role_menu")
@Data
public class TMusicRoleMenu implements Serializable {

    /**
     * 角色ID
     */
    @TableId(value = "role_id")
    private Long roleId;

    /**
     * 菜单ID
     */
    @TableField(value = "menu_id", insertStrategy = FieldStrategy.NOT_NULL)
    private Long menuId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}