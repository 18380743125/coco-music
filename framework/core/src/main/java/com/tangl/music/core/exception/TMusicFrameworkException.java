package com.tangl.music.core.exception;

/**
 * @author tangl
 * @description 技术组件层面上的异常类
 * @create 2023-07-25 21:32
 */
public class TMusicFrameworkException extends RuntimeException {

    private static final long serialVersionUID = 6627375606707630035L;

    public TMusicFrameworkException(String message) {
        super(message);
    }
}
