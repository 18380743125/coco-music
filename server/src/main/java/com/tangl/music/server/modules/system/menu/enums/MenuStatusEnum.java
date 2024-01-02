package com.tangl.music.server.modules.system.menu.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tangl
 * @description 账号状态枚举类
 * @create 2023-12-22 11:01
 */
@AllArgsConstructor
@Getter
public enum MenuStatusEnum {

    ENABLE(0, "正常"),

    DISABLE(1, "停用");

    private final Integer code;

    private final String desc;
}
