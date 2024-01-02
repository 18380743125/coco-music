package com.tangl.music.server.security.constants;

/**
 * @author tangl
 * @description 缓存的 key 常量类
 * @create 2023-12-26 16:31
 */
public interface SecurityConstants {

    /**
     * 所有权限标识
     */
    String ALL_PERMISSION = "*:*:@";

    /**
     * 超级管理员 key
     */
    String SUPER_ADMIN = "super_admin";

    String ROLE_DELIMITER = ",";

    /**
     * 允许匿名访问的url
     */
    String[] PERMIT_URL_LIST = {
            "/doc.html",
            "/v3/api-docs/**",
            "/webjars/**",
            "/user/register",
            "/user/login",
            "/**"
    };

    /**
     * 令牌前缀
     */
    String TOKEN_PREFIX = "Bearer ";

    /**
     * 密码输错次数
     */
    String PASSWORD_ERROR_COUNT_KEY = "password_error_count:";

    /**
     * 登录用户 redis key
     * 这个key对应的是一个Hash，其中存储了token、token的创建时间、登录用户信息等
     */
    String LOGIN_INFO_KEY = "login_info:";

    /**
     * 令牌前缀
     */
    String LOGIN_USER_KEY = "login_user_key";
}
