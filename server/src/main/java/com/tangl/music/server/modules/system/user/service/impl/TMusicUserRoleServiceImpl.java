package com.tangl.music.server.modules.system.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.tangl.music.core.exception.TMusicBusinessException;
import com.tangl.music.server.modules.system.role.converter.RoleConverter;
import com.tangl.music.server.modules.system.role.entity.TMusicRole;
import com.tangl.music.server.modules.system.role.service.TMusicRoleService;
import com.tangl.music.server.modules.system.role.vo.RoleVO;
import com.tangl.music.server.modules.system.user.context.AddUserRoleContext;
import com.tangl.music.server.modules.system.user.context.ChangeRoleContext;
import com.tangl.music.server.modules.system.user.entity.TMusicUserRole;
import com.tangl.music.server.modules.system.user.mapper.TMusicUserRoleMapper;
import com.tangl.music.server.modules.system.user.service.TMusicUserRoleService;
import jakarta.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author tangl
 * @description 用户角色业务层
 * @create 2023-12-21 23:23:27
 */
@Service
public class TMusicUserRoleServiceImpl extends ServiceImpl<TMusicUserRoleMapper, TMusicUserRole> implements TMusicUserRoleService {

    @Resource
    private RoleConverter roleConverter;

    @Resource
    private TMusicRoleService roleService;

    /**
     * 关联用户角色
     *
     * @param context 上下文实体
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(AddUserRoleContext context) {
        // 检查角色名称并查询角色ID
        checkRoleNameListAndQueryRoleIdList(context);
        Long userId = context.getUserId();
        List<Long> roleIdList = context.getRoleIdList();
        List<TMusicUserRole> entities = assembleUserRoleEntities(userId, roleIdList);
        if (!saveBatch(entities)) {
            throw new TMusicBusinessException("关联角色失败");
        }
    }

    /**
     * 根据用户ID查询角色名称
     *
     * @param userId 用户ID
     * @return 角色名称列表
     */
    @Override
    public List<String> queryRoleNamesById(Long userId) {
        return baseMapper.queryRoleNamesById(userId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void changeRole(ChangeRoleContext context) {
        List<Long> roleIdList = context.getRoleIdList();
        Long userId = context.getUserId();

        // 删除旧的角色信息
        if (!removeById(userId)) {
            throw new TMusicBusinessException("更新用户角色失败");
        }

        // 校验角色
        checkRoles(roleIdList);

        List<TMusicUserRole> entities = assembleUserRoleEntities(userId, roleIdList);
        if (!saveBatch(entities)) {
            throw new TMusicBusinessException("更新用户角色失败");
        }
    }

    /**
     * 根据用户ID查询角色
     *
     * @param userId 用户ID
     * @return 角色列表
     */
    @Override
    public List<RoleVO> queryRoleByUserId(Long userId) {
        List<TMusicRole> roleList = baseMapper.queryRoleByUserId(userId);
        return roleConverter.roleList2RoleVOList(roleList);
    }

    /**
     * 组装用户角色关联列表
     *
     * @param userId  用户ID
     * @param roleIds 角色ID
     * @return entities
     */
    private List<TMusicUserRole> assembleUserRoleEntities(Long userId, List<Long> roleIds) {
        List<TMusicUserRole> entities = Lists.newArrayList();
        roleIds.forEach(roleId -> {
            TMusicUserRole entity = new TMusicUserRole();
            entity.setUserId(userId);
            entity.setRoleId(roleId);
            entities.add(entity);
        });
        return entities;
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

    /**
     * 检查角色名称和查询 roleIdList
     *
     * @param context 上下文实体
     */
    private void checkRoleNameListAndQueryRoleIdList(AddUserRoleContext context) {
        List<String> roleNameList = context.getRoleNameList();
        QueryWrapper<TMusicRole> queryWrapper = Wrappers.query();
        queryWrapper.select("role_id");
        queryWrapper.in("role_name", roleNameList);
        List<Long> roleIds = roleService.listObjs(queryWrapper, value -> (Long) value);
        if (CollectionUtils.isEmpty(roleIds)) {
            throw new TMusicBusinessException("角色名称不合法");
        }
        if (roleIds.size() != roleNameList.size()) {
            throw new TMusicBusinessException("角色名称不合法");
        }
        context.setRoleIdList(roleIds);
    }
}
