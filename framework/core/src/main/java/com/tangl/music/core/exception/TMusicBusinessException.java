package com.tangl.music.core.exception;

import com.tangl.music.core.response.ResponseCode;
import lombok.Getter;

/**
 * @author tangl
 * @description 自定义全局业务异常类
 * @create 2023-11-25 18:07
 */
@Getter
public class TMusicBusinessException extends RuntimeException {

    private static final long serialVersionUID = 7138465520443359556L;

    private final Integer code;

    private final String message;

    public TMusicBusinessException(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getDesc();
    }

    public TMusicBusinessException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public TMusicBusinessException(String message) {
        this.code = ResponseCode.ERROR_PARAM.getCode();
        this.message = message;
    }

    public TMusicBusinessException() {
        this.code = ResponseCode.ERROR_PARAM.getCode();
        this.message = ResponseCode.ERROR_PARAM.getDesc();
    }
}
