package com.tangl.music.server.modules.system.menu.po;

import com.tangl.music.server.common.page.PageInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author tangl
 * @description 查询菜单入参实体
 * @create 2023-12-24 9:43
 */
@EqualsAndHashCode(callSuper = true)
@Schema(name = "查询菜单入参实体")
@Data
public class QueryMenuPO extends PageInfo implements Serializable {

    private static final long serialVersionUID = 1629824831726880550L;

    @Schema(title = "菜单名称", name = "menuName", example = "用户管理")
    private String menuName;

    @Schema(title = "菜单状态", name = "status", example = "0")
    private Integer status;
}
