package com.tangl.music.server.modules.system.role.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.tangl.music.core.exception.TMusicBusinessException;
import com.tangl.music.server.modules.system.role.context.AssignPermissionsContext;
import com.tangl.music.server.modules.system.role.context.QueryPermissionsContext;
import com.tangl.music.server.modules.system.role.entity.TMusicRole;
import com.tangl.music.server.modules.system.role.entity.TMusicRoleMenu;
import com.tangl.music.server.modules.system.role.mapper.TMusicRoleMenuMapper;
import com.tangl.music.server.modules.system.role.service.TMusicRoleMenuService;
import com.tangl.music.server.modules.system.role.service.TMusicRoleService;
import jakarta.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author tangl
 * @description 角色菜单业务层
 * @create 2023-12-21 23:23:27
 */
@Service
public class TMusicRoleMenuServiceImpl extends ServiceImpl<TMusicRoleMenuMapper, TMusicRoleMenu> implements TMusicRoleMenuService {

    @Resource
    private TMusicRoleService roleService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void assignPermissions(AssignPermissionsContext context) {
        // 检查角色
        checkRoles(Lists.newArrayList(context.getRoleId()));
        Long roleId = context.getRoleId();

        // 删除已有的权限
        QueryWrapper<TMusicRoleMenu> queryWrapper = Wrappers.query();
        queryWrapper.eq("role_id", roleId);
        remove(queryWrapper);

        // 添加权限
        List<Long> menuIds = context.getMenuIds();
        List<TMusicRoleMenu> roleMenuList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(menuIds)) {
            menuIds.forEach(menuId -> {
                TMusicRoleMenu roleMenu = new TMusicRoleMenu();
                roleMenu.setRoleId(roleId);
                roleMenu.setMenuId(menuId);
                roleMenuList.add(roleMenu);
            });
            if (!saveBatch(roleMenuList)) {
                throw new TMusicBusinessException("分配权限失败");
            }
        }
    }

    /**
     * 查询权限
     *
     * @param context 上下文实体
     * @return 权限列表
     */
    @Override
    public List<String> queryPermissions(QueryPermissionsContext context) {
        List<Long> roleIdList = context.getRoleIdList();
        if (CollectionUtils.isEmpty(roleIdList)) {
            throw new TMusicBusinessException("角色ID列表不能为空");
        }
        // 检查角色
        checkRoles(roleIdList);
        return baseMapper.queryPermissions(roleIdList);
    }

    /**
     * 校验角色
     *
     * @param roleIdList 角色ID列表
     */
    private void checkRoles(List<Long> roleIdList) {
        if (CollectionUtils.isEmpty(roleIdList)) {
            throw new TMusicBusinessException("角色不存在");
        }
        List<TMusicRole> roleList = roleService.queryByIdList(roleIdList);
        if (roleIdList.size() != roleList.size()) {
            throw new TMusicBusinessException("角色不存在");
        }
    }
}
