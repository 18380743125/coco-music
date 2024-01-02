package com.tangl.music.server.security.service;

import com.tangl.music.server.modules.system.user.context.UserLoginContext;

/**
 * @author tangl
 * @description 登录业务层
 * @create 2023-12-25 21:40
 */
public interface LoginService {

    /**
     * 用户登录
     *
     * @param context 用户登录上下文实体
     * @return token
     */
    String login(UserLoginContext context);
}
