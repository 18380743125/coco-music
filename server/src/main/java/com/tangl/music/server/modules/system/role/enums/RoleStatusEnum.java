package com.tangl.music.server.modules.system.role.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tangl
 * @description 角色状态枚举类
 * @create 2023-12-22 11:01
 */
@AllArgsConstructor
@Getter
public enum RoleStatusEnum {

    ENABLE(0, "正常"),

    DISABLE(1, "禁用");

    private final Integer code;

    private final String desc;
}
