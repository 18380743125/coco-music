package com.tangl.music.server.modules.system.user.po;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author tangl
 * @description 更新用户入参实体
 * @create 2023-12-23 11:15
 */
@Schema(name = "更新用户入参实体")
@Data
public class UpdateUserPO {

    @Schema(title = "用户ID", name = "userId", example = "0")
    private String userId;

    @Schema(title = "真实姓名", name = "realName", nullable = true, example = "张三")
    private String realName;

    @Schema(title = "性别", name = "realName", nullable = true, example = "0")
    private Integer gender;

    @Schema(title = "邮箱地址", name = "email", nullable = true, example = "2505044623@qq.com")
    private String email;

    @Schema(title = "手机号", name = "phoneNumber", nullable = true, example = "13228652251")
    private String phoneNumber;

    @Schema(title = "账号状态", name = "status", nullable = true, example = "1")
    private Integer status;
}
