package com.tangl.music.server.modules.system.user.context;

import com.tangl.music.server.modules.system.user.entity.TMusicUser;
import lombok.Data;

import java.util.List;

/**
 * @author tangl
 * @description 用户注册上下文实体
 * @create 2023-12-23 10:28
 */
@Data
public class RegisterUserContext {

    /**
     * 角色名称集合
     */
    private List<String> roleNameList;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 用户实体
     */
    private TMusicUser entity;
}
