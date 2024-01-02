package com.tangl.music.server.modules.system.role.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tangl.music.web.serializer.Date2StringSerializer;
import com.tangl.music.web.serializer.IdEncryptSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tangl
 * @description 角色列表响应实体
 * @create 2023-12-22 21:11
 */
@Schema(name = "角色列表响应实体")
@Data
public class RoleVO implements Serializable {

    private static final long serialVersionUID = 747654218655178554L;

    @Schema(title = "角色ID", name = "roleId", example = "0")
    @JsonSerialize(using = IdEncryptSerializer.class)
    private Long roleId;

    @Schema(title = "角色名称", name = "roleName", example = "普通用户")
    private String roleName;

    @Schema(title = "角色标识", name = "roleKey", example = "common")
    private String roleKey;

    @Schema(title = "显示顺序", name = "orderNum", example = "0")
    private Integer orderNum;

    @Schema(title = "角色状态", name = "status", example = "0")
    private Integer status;

    @Schema(title = "创建人", name = "createBy", example = "cooper plate")
    private String createBy;

    @Schema(title = "创建时间", name = "createTime", example = "0")
    @JsonSerialize(using = Date2StringSerializer.class)
    private Date createTime;
}
