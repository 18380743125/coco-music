package com.tangl.music.server.modules.system.role.context;

import lombok.Data;

/**
 * @author tangl
 * @description 删除角色上下文实体
 * @create 2023-12-22 20:23
 */
@Data
public class DeleteRoleContext {

    /**
     * 角色ID
     */
    private Long roleId;
}
