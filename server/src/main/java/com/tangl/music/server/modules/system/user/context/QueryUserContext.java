package com.tangl.music.server.modules.system.user.context;

import com.tangl.music.server.common.page.PageResult;
import com.tangl.music.server.modules.system.user.vo.UserVO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tangl
 * @description 查询用户列表上下文
 * @create 2023-12-23 23:42
 */
@Data
public class QueryUserContext implements Serializable {

    private static final long serialVersionUID = 1428494383442160623L;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 用户名
     */
    private String username;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 账号状态
     */
    private Integer status;

    /**
     * 账号是否注销
     */
    private Integer delFlag;

    private PageResult<UserVO> pageResult = new PageResult<>();
}
