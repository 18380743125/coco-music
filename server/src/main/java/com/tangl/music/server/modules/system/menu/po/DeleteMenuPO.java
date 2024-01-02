package com.tangl.music.server.modules.system.menu.po;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tangl
 * @description 删除菜单入参实体
 * @create 2023-12-24 9:33
 */
@Schema(name = "删除菜单入参实体")
@Data
public class DeleteMenuPO implements Serializable {

    private static final long serialVersionUID = -6916747396459629481L;

    @Schema(title = "菜单ID", name = "menuId", example = "0")
    @NotBlank(message = "菜单ID不能为空")
    private String menuId;
}
