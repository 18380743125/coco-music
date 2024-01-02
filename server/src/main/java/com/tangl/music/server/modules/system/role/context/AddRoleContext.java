package com.tangl.music.server.modules.system.role.context;

import com.tangl.music.server.modules.system.role.entity.TMusicRole;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tangl
 * @description 新增角色上下文实体
 * @create 2023-12-22 10:34
 */
@Data
public class AddRoleContext implements Serializable {

    private static final long serialVersionUID = -7678376630960128091L;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色标识
     *
     */
    private String roleKey;

    /**
     * 显示顺序
     */
    private Integer orderNum;

    /**
     * 角色实体
     */
    private TMusicRole entity;
}
