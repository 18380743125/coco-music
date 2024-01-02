package com.tangl.music.server.modules.system.role.context;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author tangl
 * @description
 * @create 2023-12-24 18:55
 */
@Data
public class AssignPermissionsContext implements Serializable {

    private static final long serialVersionUID = 662605286534901443L;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 菜单ID列表
     */
    private List<Long> menuIds;
}
