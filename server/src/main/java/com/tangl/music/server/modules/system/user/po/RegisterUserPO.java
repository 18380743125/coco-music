package com.tangl.music.server.modules.system.user.po;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * @author tangl
 * @description 注册用户入参实体
 * @create 2023-12-23 10:27
 */
@Schema(name = "注册用户入参实体")
@Data
public class RegisterUserPO implements Serializable {

    private static final long serialVersionUID = 1724177415687035483L;

    @Schema(title = "角色名称集合", name = "roleNames", example = "管理员__,__普通用户")
    @NotBlank(message = "角色名称不能为空")
    private String roleNames;

    @Schema(title = "真实姓名", name = "realName", example = "张三")
    @NotBlank(message = "姓名不能为空")
    @Length(max = 60, message = "真实姓名不能超过60个字符")
    private String realName;

    @Schema(title = "用户名", name = "username", example = "cooper plate")
    @NotBlank(message = "用户名不能为空")
    @Length(max = 32, message = "用户名不能超过32个字符")
    private String username;

    @Schema(title = "密码", name = "password", example = "123456")
    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 16, message = "请输入6-16位的密码")
    private String password;

    @Schema(title = "性别", name = "realName", example = "0")
    private Integer gender;

    @Schema(title = "邮箱地址", name = "email", example = "2505044623@qq.com")
    @Length(max = 50, message = "邮箱地址不能超过50个字符")
    private String email;

    @Schema(title = "手机号", name = "phoneNumber", example = "13228652251")
    @Length(max = 11, message = "手机号不能超过11个字符")
    private String phoneNumber;
}
