package com.tangl.music.server.modules.system.role.context;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author tangl
 * @description 查询权限上下文
 * @create 2023-12-24 20:49
 */
@Data
public class QueryPermissionsContext implements Serializable {

    private static final long serialVersionUID = 4547750847874270780L;

    /**
     * 角色ID列表
     */
    private List<Long> roleIdList;
}
