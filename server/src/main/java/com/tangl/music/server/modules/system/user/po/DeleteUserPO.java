package com.tangl.music.server.modules.system.user.po;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tangl
 * @description 删除用户入参实体
 * @create 2023-12-23 11:04
 */
@Schema(name = "删除用户入参实体")
@Data
public class DeleteUserPO implements Serializable {

    private static final long serialVersionUID = -1400859712160416036L;

    @Schema(title = "用户ID", name="userId", example = "0")
    private String userId;
}
