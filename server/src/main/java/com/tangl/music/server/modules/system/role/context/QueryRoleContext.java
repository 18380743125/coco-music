package com.tangl.music.server.modules.system.role.context;

import com.tangl.music.server.common.page.PageResult;
import com.tangl.music.server.modules.system.role.vo.RoleVO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tangl
 * @description 查询角色上下文实体
 * @create 2023-12-22 20:44
 */
@Data
public class QueryRoleContext implements Serializable {

    private static final long serialVersionUID = -4804191624068674450L;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色状态
     */
    private String status;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 分页对象
     */
    private PageResult<RoleVO> pageResult = new PageResult<>();
}
