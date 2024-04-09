package com.tangl.music.server.modules.user.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户表
 */
@TableName(value = "coco_user")
@Data
public class CoCoUser implements Serializable {

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "user_id")
    private Long userId;

    /**
     * 用户名
     */
    @TableField(value = "username", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String password;

    /**
     * 手机号
     */
    @TableField(value = "phone", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String phone;

    /**
     * 邮箱地址
     */
    @TableField(value = "email", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String email;

    /**
     * 头像存储路径
     */
    @TableField(value = "photo", updateStrategy = FieldStrategy.NOT_EMPTY)
    private String photo;

    /**
     * 注册时间
     */
    @TableField(value = "create_time", updateStrategy = FieldStrategy.NOT_NULL)
    private Date createTime;
}
