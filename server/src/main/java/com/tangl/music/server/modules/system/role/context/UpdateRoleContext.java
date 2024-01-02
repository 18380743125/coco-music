package com.tangl.music.server.modules.system.role.context;

import lombok.Data;

/**
 * @author tangl
 * @description 更新角色上下文实体
 * @create 2023-12-22 20:34
 */
@Data
public class UpdateRoleContext {

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色标识
     */
    private String roleKey;

    /**
     * 显示顺序
     */
    private Integer orderNum;

    /**
     * 角色状态
     */
    private Integer status;
}
