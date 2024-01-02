package com.tangl.music.server.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tangl
 * @description 角色标识枚举类
 * @create 2023-12-22 11:01
 */
@AllArgsConstructor
@Getter
public enum RoleKeyEnum {

    SUPER_ADMIN("super_admin", "超级管理员"),

    ADMIN("admin", "管理员"),

    COMMON("common", "普通用户"),

    TEST("test", "测试");

    private final String key;

    private final String desc;
}
