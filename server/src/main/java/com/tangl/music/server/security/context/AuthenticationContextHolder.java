package com.tangl.music.server.security.context;

import org.springframework.security.core.Authentication;

/**
 * @author tangl
 * @description
 * @create 2023-12-25 18:24
 */
public class AuthenticationContextHolder {

    private static final ThreadLocal<Authentication> contextHolder = new ThreadLocal<>();

    public static Authentication getContext() {
        return contextHolder.get();
    }

    public static void setContext(Authentication context) {
        contextHolder.set(context);
    }

    public static void clear() {
        contextHolder.remove();
    }
}
