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
public enum MenuTypeEnum {

    MENU(0, "菜单"),

    PAGE(1, "页面"),

    BUTTON(2, "按钮");

    private final Integer code;

    private final String desc;
}
