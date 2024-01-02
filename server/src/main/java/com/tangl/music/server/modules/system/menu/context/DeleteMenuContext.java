package com.tangl.music.server.modules.system.menu.context;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tangl
 * @description 删除菜单上下文实体
 * @create 2023-12-24 9:33
 */
@Data
public class DeleteMenuContext implements Serializable {

    private static final long serialVersionUID = 3203904092115576455L;

    /**
     * 菜单ID
     */
    private Long menuId;
}
