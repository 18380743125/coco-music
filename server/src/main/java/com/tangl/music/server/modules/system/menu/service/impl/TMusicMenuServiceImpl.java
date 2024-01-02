package com.tangl.music.server.modules.system.menu.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangl.music.core.exception.TMusicBusinessException;
import com.tangl.music.core.utils.IdUtil;
import com.tangl.music.server.common.enums.DelFlagEnum;
import com.tangl.music.server.common.page.PageResult;
import com.tangl.music.server.modules.system.menu.context.AddMenuContext;
import com.tangl.music.server.modules.system.menu.context.DeleteMenuContext;
import com.tangl.music.server.modules.system.menu.context.QueryMenuContext;
import com.tangl.music.server.modules.system.menu.context.UpdateMenuContext;
import com.tangl.music.server.modules.system.menu.converter.MenuConverter;
import com.tangl.music.server.modules.system.menu.entity.TMusicMenu;
import com.tangl.music.server.modules.system.menu.enums.MenuStatusEnum;
import com.tangl.music.server.modules.system.menu.mapper.TMusicMenuMapper;
import com.tangl.music.server.modules.system.menu.service.TMusicMenuService;
import com.tangl.music.server.modules.system.menu.vo.MenuVO;
import jakarta.annotation.Resource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author tangl
 * @description 菜单业务层
 * @create 2023-12-21 23:23:26
 */
@Service
public class TMusicMenuServiceImpl extends ServiceImpl<TMusicMenuMapper, TMusicMenu> implements TMusicMenuService {

    @Resource
    private MenuConverter converter;

    /**
     * 新增菜单
     *
     * @param context 上下文实体
     */
    @Override
    public void add(AddMenuContext context) {
        // 组装菜单实体
        assembleMenuEntity(context);
        TMusicMenu entity = context.getEntity();
        try {
            if (!save(entity)) {
                throw new TMusicBusinessException("新增菜单失败");
            }
        } catch (DuplicateKeyException e) {
            throw new TMusicBusinessException("菜单名称已存在");
        }
    }

    /**
     * 删除菜单
     *
     * @param context 上下文实体
     */
    @Override
    public void delete(DeleteMenuContext context) {
        UpdateWrapper<TMusicMenu> updateWrapper = Wrappers.update();
        updateWrapper.eq("menu_id", context.getMenuId());
        updateWrapper.set("del_flag", DelFlagEnum.YES.getCode());
        updateWrapper.set("update_by", 0);
        updateWrapper.set("update_time", new Date());
        if (!update(updateWrapper)) {
            throw new TMusicBusinessException("删除菜单失败");
        }
    }

    /**
     * 更新菜单
     *
     * @param context 上下文实体
     */
    @Override
    public void update(UpdateMenuContext context) {
        TMusicMenu menu = converter.updateMenuContext2Menu(context);
        menu.setUpdateBy(0L);
        menu.setUpdateTime(new Date());
        try {
            Integer count = baseMapper.updateMenu(menu);
            if (count == 0) {
                throw new TMusicBusinessException("更新失败");
            }
        } catch (DuplicateKeyException e) {
            throw new TMusicBusinessException("菜单名称已存在");
        }
    }

    /**
     * 查询菜单
     *
     * @param context 上下文实体
     */
    @Override
    public void queryPage(QueryMenuContext context) {
        PageResult<MenuVO> pageResult = context.getPageResult();
        Integer offset = pageResult.getOffset();
        Integer pageSize = pageResult.getPageSize();
        // 数据
        List<TMusicMenu> menuList = baseMapper.queryPage(context, offset, pageSize);
        // 行数
        Long count = baseMapper.count(context);
        List<MenuVO> menuVOList = converter.menuList2MenuVOList(menuList);
        pageResult.setRecords(menuVOList);
        pageResult.setTotal(count.intValue());
    }

    /**
     * 组装菜单实体
     *
     * @param context 上下文实体
     */
    private void assembleMenuEntity(AddMenuContext context) {
        TMusicMenu entity = converter.addMenuContext2Menu(context);
        entity.setMenuId(IdUtil.get());
        entity.setStatus(MenuStatusEnum.ENABLE.getCode());
        entity.setCreateBy(0L);
        entity.setCreateTime(new Date());
        entity.setDelFlag(DelFlagEnum.NO.getCode());
        context.setEntity(entity);
    }
}
