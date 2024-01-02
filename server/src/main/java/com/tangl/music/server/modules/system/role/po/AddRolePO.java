package com.tangl.music.server.modules.system.role.po;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * @author tangl
 * @description 新增角色入参实体
 * @create 2023-12-22 10:23
 */
@Schema(name = "新增角色入参实体")
@Data
public class AddRolePO implements Serializable {

    private static final long serialVersionUID = -5613472985218322282L;

    @Schema(title = "角色名称", name = "roleName", example = "普通用户")
    @NotBlank(message = "角色名称不能为空")
    @Length(min = 2, max = 32, message = "请输入2-32个字符的角色名称")
    private String roleName;

    @Schema(title = "角色标识", name = "roleName", example = "common")
    @NotBlank(message = "角色标识不能为空")
    @Length(max = 100, message = "角色标识不能超过100个字符")
    private String roleKey;

    @Schema(title = "显示顺序", name = "orderNum", example = "0")
    @NotNull(message = "显示顺序不能为空")
    private Integer orderNum;
}
