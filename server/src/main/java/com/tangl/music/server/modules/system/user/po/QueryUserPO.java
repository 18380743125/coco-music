package com.tangl.music.server.modules.system.user.po;

import com.tangl.music.server.common.page.PageInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * @author tangl
 * @description 查询用户列表入参实体
 * @create 2023-12-23 23:42
 */
@EqualsAndHashCode(callSuper = true)
@Schema(name = "查询用户列表入参实体")
@Data
public class QueryUserPO extends PageInfo implements Serializable {

    private static final long serialVersionUID = 7646646317295876523L;

    @Schema(title = "真实名称", name = "realName", example = "张三")
    @Length(max = 60, message = "真实姓名不能超过60个字符")
    private String realName;

    @Schema(title = "用户名", name = "username", example = "cooper plate")
    @Length(max = 32, message = "用户名不能超过32个字符")
    private String username;

    @Schema(title = "性别", name = "gender", example = "0")
    private String gender;

    @Schema(title = "邮箱", name = "email", example = "xxx@qq.com")
    @Length(max = 50, message = "邮箱地址不能超过50个字符")
    private String email;

    @Schema(title = "手机号", name = "phoneNumber", example = "13228652251")
    private String phoneNumber;

    @Schema(title = "账号状态", name = "status", example = "0")
    private Integer status;

    @Schema(title = "账号是否注销", name = "delFlag", example = "0")
    private Integer delFlag;
}
