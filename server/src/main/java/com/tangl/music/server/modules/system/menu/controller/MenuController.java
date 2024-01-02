package com.tangl.music.server.modules.system.menu.controller;

import com.tangl.music.core.response.R;
import com.tangl.music.core.utils.IdUtil;
import com.tangl.music.server.common.page.PageResult;
import com.tangl.music.server.modules.system.menu.context.AddMenuContext;
import com.tangl.music.server.modules.system.menu.context.DeleteMenuContext;
import com.tangl.music.server.modules.system.menu.context.QueryMenuContext;
import com.tangl.music.server.modules.system.menu.context.UpdateMenuContext;
import com.tangl.music.server.modules.system.menu.converter.MenuConverter;
import com.tangl.music.server.modules.system.menu.po.AddMenuPO;
import com.tangl.music.server.modules.system.menu.po.DeleteMenuPO;
import com.tangl.music.server.modules.system.menu.po.QueryMenuPO;
import com.tangl.music.server.modules.system.menu.po.UpdateMenuPO;
import com.tangl.music.server.modules.system.menu.service.TMusicMenuService;
import com.tangl.music.server.modules.system.menu.vo.MenuVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author tangl
 * @description 菜单模块控制器
 * @create 2023-12-22 0:00
 */
@Tag(name = "菜单模块")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private TMusicMenuService menuService;

    @Resource
    private MenuConverter converter;

    @Operation(summary = "新增菜单", description = "该接口提供了新增菜单的功能")
    @PostMapping("add")
    public R<?> add(@Validated @RequestBody AddMenuPO addMenuPO) {
        AddMenuContext context = converter.addMenuPO2AddMenuContext(addMenuPO);
        if (StringUtils.isNotBlank(addMenuPO.getParentId())) {
            context.setParentId(IdUtil.decrypt(addMenuPO.getParentId()));
        }
        menuService.add(context);
        return R.success();
    }

    @Operation(summary = "删除菜单", description = "该接口提供了删除菜单的功能")
    @DeleteMapping("delete")
    public R<?> delete(@Validated @RequestBody DeleteMenuPO deleteMenuPO) {
        DeleteMenuContext context = converter.deleteMenuPO2DeleteMenuContext(deleteMenuPO);
        menuService.delete(context);
        return R.success();
    }

    @Operation(summary = "更新菜单", description = "该接口提供了更新菜单的功能")
    @PutMapping("update")
    public R<?> update(@Validated @RequestBody UpdateMenuPO updateMenuPO) {
        UpdateMenuContext context = converter.updateMenuPO2UpdateMenuContext(updateMenuPO);
        if (StringUtils.isNotBlank(updateMenuPO.getParentId())) {
            context.setParentId(IdUtil.decrypt(updateMenuPO.getParentId()));
        }
        menuService.update(context);
        return R.success();
    }

    @Operation(summary = "查询菜单", description = "该接口提供了查询菜单的功能")
    @PostMapping("query")
    public R<PageResult<MenuVO>> query(@Validated @RequestBody QueryMenuPO queryMenuPO) {
        QueryMenuContext context = converter.queryMenuPO2QueryMenuContext(queryMenuPO);
        PageResult<MenuVO> pageResult = context.getPageResult();
        pageResult.setPageNo(queryMenuPO.getPageNo());
        pageResult.setPageSize(queryMenuPO.getPageSize());
        // 分页条件查询
        menuService.queryPage(context);
        return R.data(pageResult);
    }
}
