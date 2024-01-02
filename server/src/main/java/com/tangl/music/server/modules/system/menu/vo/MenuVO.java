package com.tangl.music.server.modules.system.menu.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tangl.music.web.serializer.Date2StringSerializer;
import com.tangl.music.web.serializer.IdEncryptSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tangl
 * @description 菜单响应实体
 * @create 2023-12-24 9:41
 */
@Data
public class MenuVO implements Serializable {

    private static final long serialVersionUID = 8681152228741286060L;

    @Schema(title = "菜单ID", name = "menuId", example = "0")
    @JsonSerialize(using = IdEncryptSerializer.class)
    private Long menuId;

    @Schema(title = "菜单名称", name = "menuName", example = "用户管理")
    private String menuName;

    @Schema(title = "父级菜单ID", name = "parentId", example = "0")
    @JsonSerialize(using = IdEncryptSerializer.class)
    private Long parentId;

    @Schema(title = "路由地址", name = "path", example = "/user")
    private String path;

    @Schema(title = "菜单路径", name = "component", example = "/system/user/list")
    private String component;

    @Schema(title = "权限标识", name = "permission", example = "system:user@query")
    private String permission;

    @Schema(title = "菜单类型", name = "menuType", example = "0")
    private Integer menuType;

    @Schema(title = "菜单图标", name = "icon", example = "x-o")
    private String icon;

    @Schema(title = "显示顺序", name = "orderNum", example = "0")
    private Integer orderNum;

    @Schema(title = "菜单状态", name = "status", example = "0")
    private Integer status;

    @Schema(title = "创建者", name = "createBy", example = "0")
    private Long createBy;

    @Schema(title = "创建时间", name = "createTime", example = "")
    @JsonSerialize(using = Date2StringSerializer.class)
    private Date createTime;

    @Schema(title = "更新人", name = "updateBy", example = "0")
    private Long updateBy;

    @Schema(title = "更新时间", name = "updateTime", example = "")
    @JsonSerialize(using = Date2StringSerializer.class)
    private Date updateTime;

    @Schema(title = "是否删除", name = "delFlag", example = "0")
    private Integer delFlag;
}
