package com.tangl.music.server.modules.system.role.po;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tangl
 * @description 删除角色入参实体
 * @create 2023-12-22 20:18
 */
@Schema(name = "删除角色入参实体")
@Data
public class DeleteRolePO implements Serializable {

    private static final long serialVersionUID = 508084395635535041L;

    @Schema(title = "角色ID", name = "roleId", example = "0")
    @NotBlank(message = "角色ID不能为空")
    private String roleId;
}
