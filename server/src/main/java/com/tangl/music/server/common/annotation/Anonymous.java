package com.tangl.music.server.common.annotation;

import java.lang.annotation.*;

/**
 * @author tangl
 * @description 匿名访问不鉴权注解
 * @create 2023-12-26 22:08
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Anonymous {
}
