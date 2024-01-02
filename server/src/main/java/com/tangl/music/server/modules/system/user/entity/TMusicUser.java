package com.tangl.music.server.modules.system.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 *
 * @TableName t_music_user
 */
@TableName(value = "t_music_user")
@Data
public class TMusicUser implements Serializable {
    /**
     * 用户ID
     */
    @TableId(value = "user_id")
    private Long userId;

    /**
     * 真实姓名
     */
    @TableField(value = "real_name")
    private String realName;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 用户性别（0-男，1-女，2-未知）
     */
    @TableField(value = "gender")
    private Integer gender;

    /**
     * 用户邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 手机号码
     */
    @TableField(value = "phone_number")
    private String phoneNumber;

    /**
     * 头像文件ID
     */
    @TableField(value = "avatar_file_id")
    private Long avatarFileId;

    /**
     * 账号状态（0-正常，1-停用）
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 最近登录IP
     */
    @TableField(value = "login_ip")
    private String loginIp;

    /**
     * 最近登录时间
     */
    @TableField(value = "login_date")
    private Date loginDate;

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