package com.tangl.music.server.modules.system.user.context;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tangl
 * @description 用户登录上下文实体
 * @create 2023-12-25 18:10
 */
@Data
public class UserLoginContext implements Serializable {

    private static final long serialVersionUID = -92554167806612972L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
