package com.tangl.music.server.modules.system.user.context;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tangl
 * @description
 * @create 2023-12-23 11:08
 */
@Data
public class DeleteUserContext implements Serializable {

    private static final long serialVersionUID = -366121024060586439L;

    /**
     * 用户ID
     */
    private Long userId;
}
