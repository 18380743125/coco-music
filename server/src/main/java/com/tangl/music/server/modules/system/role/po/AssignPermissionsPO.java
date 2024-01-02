package com.tangl.music.server.modules.system.role.po;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tangl
 * @description 分配权限入参实体
 * @create 2023-12-24 18:55
 */
@Schema(name = "分配权限入参实体")
@Data
public class AssignPermissionsPO implements Serializable {

    private static final long serialVersionUID = 34103194840076078L;

    @Schema(title = "角色ID", name = "roleId", example = "0")
    @NotBlank(message = "角色ID不能为空")
    private String roleId;

    @Schema(title = "菜单ID列表", name = "menuIds", example = "__,__")
    private String menuIds;
}
