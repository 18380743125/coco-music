package com.tangl.music.server.modules.system.user.context;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author tangl
 * @description
 * @create 2023-12-24 17:44
 */
@Data
public class AddUserRoleContext implements Serializable {

    private static final long serialVersionUID = -4509622716013467904L;

    private Long userId;

    private List<String> roleNameList;

    private List<Long> roleIdList;
}
