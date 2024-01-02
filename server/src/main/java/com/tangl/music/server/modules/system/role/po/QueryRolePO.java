package com.tangl.music.server.modules.system.role.po;

import com.tangl.music.server.common.page.PageInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author tangl
 * @description 查询角色列表入参实体
 * @create 2023-12-22 20:42
 */
@EqualsAndHashCode(callSuper = true)
@Schema(name = "查询角色列表入参实体")
@Data
public class QueryRolePO extends PageInfo implements Serializable {

    private static final long serialVersionUID = -7935444457501960905L;

    @Schema(title = "角色名称", name = "roleName", example = "普通用户")
    private String roleName;

    @Schema(title = "角色状态", name = "status", example = "0")
    private String status;

    @Schema(title = "创建人", name = "createBy", example = "cooper plate")
    private String createBy;
}
