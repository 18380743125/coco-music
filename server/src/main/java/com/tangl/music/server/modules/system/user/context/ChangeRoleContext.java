package com.tangl.music.server.modules.system.user.context;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author tangl
 * @description 更新用户角色上下文
 * @create 2023-12-24 21:30
 */
@Data
public class ChangeRoleContext implements Serializable {

    private static final long serialVersionUID = 2891316193187782816L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private List<Long> roleIdList;
}
