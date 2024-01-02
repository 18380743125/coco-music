package com.tangl.music.server.modules.system.user.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tangl.music.server.modules.system.role.vo.RoleVO;
import com.tangl.music.web.serializer.Date2StringSerializer;
import com.tangl.music.web.serializer.IdEncryptSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author tangl
 * @description 用户列表响应实体
 * @create 2023-12-23 23:26
 */
@Schema(name = "用户列表响应实体")
@Getter
@Setter
public class UserVO implements Serializable {

    private static final long serialVersionUID = -2400726869258581777L;

    @JsonIgnore
    private String password;

    @Schema(title = "角色列表", name = "roleList", example = "[]")
    private List<RoleVO> roleList;

    @Schema(title = "用户ID", name = "userId", example = "0")
    @JsonSerialize(using = IdEncryptSerializer.class)
    private Long userId;

    @Schema(title = "真实姓名", name = "realName", example = "张三")
    private String realName;

    @Schema(title = "用户名", name = "username", example = "cooper plate")
    private String username;

    @Schema(title = "性别", name = "gender", example = "0")
    private String gender;

    @Schema(title = "邮箱", name = "email", example = "0")
    private String email;

    @Schema(title = "手机号", name = "phoneNumber", example = "0")
    private String phoneNumber;

    @Schema(title = "头像地址", name = "avatarUrl", example = "xxx")
    private String avatarUrl;

    @Schema(title = "账号状态", name = "status", example = "0")
    private Integer status;

    @Schema(title = "最近登录IP", name = "loginIp", example = "0")
    private String loginIp;

    @Schema(title = "最近登录时间", name = "loginDate", example = "0")
    @JsonSerialize(using = Date2StringSerializer.class)
    private Date loginDate;

    @Schema(title = "账号是否注销", name = "delFlag", example = "0")
    private Integer delFlag;
}
