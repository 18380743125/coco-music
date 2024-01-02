package com.tangl.music.server.security.service;

import com.tangl.music.server.modules.system.user.vo.UserVO;

/**
 * @author tangl
 * @description
 * @create 2023-12-25 21:40
 */
public interface PasswordService {
    /**
     * 验证用户名密码
     *
     * @param user 用户对象
     */
    void validate(UserVO user);
}
