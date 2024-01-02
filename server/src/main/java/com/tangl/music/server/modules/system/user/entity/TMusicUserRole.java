package com.tangl.music.server.modules.system.user.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户角色关联表
 *
 * @TableName t_music_user_role
 */
@TableName(value = "t_music_user_role")
@Data
public class TMusicUserRole implements Serializable {

    /**
     * 用户ID
     */
    @TableId(value = "user_id")
    private Long userId;

    /**
     * 角色ID
     */
    @TableField(value = "role_id", insertStrategy = FieldStrategy.IGNORED)
    private Long roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}