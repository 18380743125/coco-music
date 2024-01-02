package com.tangl.music.server.modules.system.user.po;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * @author tangl
 * @description 用户登录入参实体
 * @create 2023-12-25 18:07
 */
@Schema(name = "用户登录入参实体")
@Data
public class UserLoginPO implements Serializable {

    private static final long serialVersionUID = 7090019884876091498L;

    @Schema(title = "用户名", name = "username", example = "cooper plate")
    @NotBlank(message = "用户名不能为空")
    @Length(max = 16, min = 6, message = "请输入6-16位的用户名")
    private String username;

    @Schema(title = "密码", name = "password", example = "123456")
    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 16, message = "请输入6-16位的密码")
    private String password;
}
