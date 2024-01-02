package com.tangl.music.server.security.service;

import com.tangl.music.server.security.entity.LoginUser;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @author tangl
 * @description
 * @create 2023-12-25 21:38
 */
public interface TokenService {

    LoginUser getLoginUser(HttpServletRequest request);

    String createToken(LoginUser loginUser);

    void delLoginUser(String token);

    void verifyToken(LoginUser loginUser);
}
