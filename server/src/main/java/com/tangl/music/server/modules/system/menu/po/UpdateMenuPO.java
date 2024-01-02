package com.tangl.music.server.modules.system.menu.po;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * @author tangl
 * @description 更新菜单入参实体
 * @create 2023-12-24 9:38
 */
@Schema(name = "更新菜单入参实体")
@Data
public class UpdateMenuPO implements Serializable {

    private static final long serialVersionUID = -6799363373267774298L;

    @Schema(title = "菜单ID", name = "menuId", example = "0")
    @NotBlank(message = "菜单ID不能为空")
    private String menuId;

    @Schema(title = "菜单名称", name = "menuName", example = "用户管理")
    private String menuName;

    @Schema(title = "父级菜单ID", name = "parentId", example = "0")
    private String parentId;

    @Schema(title = "路由地址", name = "path", example = "/user")
    @Length(max = 255, message = "路由地址不能超过255个字符")
    private String path;

    @Schema(title = "菜单路径", name = "component", example = "/system/user/list")
    @Length(max = 255, message = "菜单路径不能超过255个字符")
    private String component;

    @Schema(title = "权限标识", name = "permission", example = "system:user@query")
    @Length(max = 100, message = "权限标识不能超过100个字符")
    private String permission;

    @Schema(title = "菜单类型", name = "menuType", example = "0")
    private Integer menuType;

    @Schema(title = "菜单图标", name = "icon", example = "x-o")
    @Length(max = 50, message = "菜单图标不能超过50个字符")
    private String icon;

    @Schema(title = "显示顺序", name = "orderNum", example = "0")
    private Integer orderNum;

    @Schema(title = "菜单状态", name = "status", example = "0")
    private Integer status;
}
