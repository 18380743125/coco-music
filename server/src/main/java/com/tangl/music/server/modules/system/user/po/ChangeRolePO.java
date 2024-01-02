package com.tangl.music.server.modules.system.user.po;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tangl
 * @description 更新用户角色入参实体
 * @create 2023-12-24 21:28
 */
@Schema(name = "更新用户角色入参实体")
@Data
public class ChangeRolePO implements Serializable {

    private static final long serialVersionUID = 4404006052909512716L;

    @Schema(title = "用户ID", name = "userId")
    private String userId;

    @Schema(title = "角色ID", name = "roleIds")
    @NotBlank(message = "角色ID不能为空")
    private String roleIds;
}
