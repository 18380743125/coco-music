package com.tangl.music.server.modules.system.user.context;

import lombok.Data;

/**
 * @author tangl
 * @description 更新用户上下文实体
 * @create 2023-12-23 10:28
 */
@Data
public class UpdateUserContext {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 真实姓名
     */
    private String realName;

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
     * 账号状态
     */
    private Integer status;

}
