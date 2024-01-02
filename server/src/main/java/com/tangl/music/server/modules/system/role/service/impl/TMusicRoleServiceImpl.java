package com.tangl.music.server.modules.system.role.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangl.music.core.exception.TMusicBusinessException;
import com.tangl.music.core.utils.IdUtil;
import com.tangl.music.server.common.enums.DelFlagEnum;
import com.tangl.music.server.common.page.PageResult;
import com.tangl.music.server.modules.system.role.context.AddRoleContext;
import com.tangl.music.server.modules.system.role.context.DeleteRoleContext;
import com.tangl.music.server.modules.system.role.context.QueryRoleContext;
import com.tangl.music.server.modules.system.role.context.UpdateRoleContext;
import com.tangl.music.server.modules.system.role.converter.RoleConverter;
import com.tangl.music.server.modules.system.role.entity.TMusicRole;
import com.tangl.music.server.modules.system.role.enums.RoleStatusEnum;
import com.tangl.music.server.modules.system.role.mapper.TMusicRoleMapper;
import com.tangl.music.server.modules.system.role.service.TMusicRoleService;
import com.tangl.music.server.modules.system.role.vo.RoleVO;
import jakarta.annotation.Resource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author tangl
 * @description 角色业务层
 * @create 2023-12-21 23:23:26
 */
@Service
public class TMusicRoleServiceImpl extends ServiceImpl<TMusicRoleMapper, TMusicRole> implements TMusicRoleService {

    @Resource
    private RoleConverter converter;

    /**
     * 新增角色
     *
     * @param context 上下文实体
     */
    @Override
    public void add(AddRoleContext context) {
        assembleRoleEntity(context);
        TMusicRole entity = context.getEntity();
        try {
            if (!save(entity)) {
                throw new TMusicBusinessException("新增角色失败");
            }
        } catch (DuplicateKeyException e) {
            throw new TMusicBusinessException("角色名称已存在");
        }
    }

    /**
     * 删除角色
     *
     * @param context 上下文实体
     */
    @Override
    public void delete(DeleteRoleContext context) {
        Long roleId = context.getRoleId();
        UpdateWrapper<TMusicRole> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("role_id", roleId);
        updateWrapper.set("del_flag", DelFlagEnum.YES.getCode());
        updateWrapper.set("update_by", 0);
        updateWrapper.set("update_time", new Date());
        if (!update(updateWrapper)) {
            throw new TMusicBusinessException("删除角色失败");
        }
    }

    /**
     * 更新角色
     *
     * @param context 上下文实体
     */
    @Override
    public void update(UpdateRoleContext context) {
        TMusicRole role = converter.updateRoleContext2Role(context);
        role.setUpdateBy(0L);
        role.setUpdateTime(new Date());
        try {
            Integer count = baseMapper.updateRole(role);
            if (count == 0) {
                throw new TMusicBusinessException("更新角色信息失败");
            }
        } catch (DuplicateKeyException e) {
            throw new TMusicBusinessException("角色名称已存在");
        }
    }

    /**
     * 查询角色
     *
     * @param context 上下文实体
     */
    @Override
    public void queryPage(QueryRoleContext context) {
        PageResult<RoleVO> pageResult = context.getPageResult();
        Integer offset = pageResult.getOffset();
        Integer pageSize = pageResult.getPageSize();
        // 数据
        List<TMusicRole> roleList = baseMapper.queryPage(context, offset, pageSize);
        // 行数
        Long count = baseMapper.count(context);
        List<RoleVO> roleVOList = converter.roleList2RoleVOList(roleList);
        pageResult.setTotal(count.intValue());
        pageResult.setRecords(roleVOList);
    }

    /**
     * 根据角色ID查询
     *
     * @param roleIdList 角色ID列表
     * @return 角色列表
     */
    @Override
    public List<TMusicRole> queryByIdList(List<Long> roleIdList) {
        return baseMapper.queryByIdList(roleIdList);
    }

    /**
     * 组装角色实体
     *
     * @param context 上下文实体
     */
    private void assembleRoleEntity(AddRoleContext context) {
        TMusicRole entity = converter.addRoleContext2TMusicRole(context);
        entity.setRoleId(IdUtil.get());
        entity.setStatus(RoleStatusEnum.ENABLE.getCode());
        entity.setDelFlag(DelFlagEnum.NO.getCode());
        entity.setCreateBy(0L);
        entity.setCreateTime(new Date());
        context.setEntity(entity);
    }
}
