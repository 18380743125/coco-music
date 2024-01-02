package com.tangl.music.server.modules.system.menu.context;

import com.tangl.music.server.common.page.PageResult;
import com.tangl.music.server.modules.system.menu.vo.MenuVO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tangl
 * @description 查询菜单上下文实体
 * @create 2023-12-24 9:43
 */
@Data
public class QueryMenuContext implements Serializable {

    private static final long serialVersionUID = 3369605389133025881L;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单状态
     */
    private Integer status;

    private PageResult<MenuVO> pageResult = new PageResult<>();
}
