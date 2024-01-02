package com.tangl.music.server.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tangl
 * @description 删除标识枚举类
 * @create 2023-07-29 22:47
 */
@AllArgsConstructor
@Getter
public enum DelFlagEnum {

    /**
     * 未删除
     */
    NO(0, "未删除"),

    /**
     * 已删除
     */
    YES(1, "已删除");

    private final Integer code;

    private final String desc;
}
