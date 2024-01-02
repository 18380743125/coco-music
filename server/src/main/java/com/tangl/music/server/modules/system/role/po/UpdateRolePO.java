package com.tangl.music.server.modules.system.role.po;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @author tangl
 * @description 更新角色入参实体
 * @create 2023-12-22 20:32
 */
@Schema(name = "更新角色入参实体")
@Data
public class UpdateRolePO {

    @Schema(title = "角色ID", name = "roleId", example = "0")
    @NotBlank(message = "角色ID不能为空")
    private String roleId;

    @Schema(title = "角色名称", name = "roleName", example = "普通用户")
    @Length(min = 2, max = 32, message = "请输入2-32个字符的角色名称")
    private String roleName;

    @Schema(title = "角色标识", name = "roleName", example = "common")
    @Length(max = 100, message = "角色标识不能超过100个字符")
    private String roleKey;

    @Schema(title = "显示顺序", name = "orderNum", example = "0")
    private Integer orderNum;

    @Schema(title = "角色状态", name = "status", example = "0")
    private Integer status;
}
