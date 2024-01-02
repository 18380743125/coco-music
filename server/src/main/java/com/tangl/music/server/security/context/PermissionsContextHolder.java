package com.tangl.music.server.security.context;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * @author tangl
 * @description
 * @create 2023-12-25 18:45
 */
public class PermissionsContextHolder {

    private static final String PERMISSION_CONTEXT_ATTRIBUTES = "PERMISSION_CONTEXT";

    public static void setContext(String permissions) {
        RequestContextHolder.currentRequestAttributes().setAttribute(PERMISSION_CONTEXT_ATTRIBUTES,
                permissions, RequestAttributes.SCOPE_REQUEST);
    }

    public static String getContext() {
        return (String) RequestContextHolder.currentRequestAttributes().getAttribute(PERMISSION_CONTEXT_ATTRIBUTES,
                RequestAttributes.SCOPE_REQUEST);
    }
}
