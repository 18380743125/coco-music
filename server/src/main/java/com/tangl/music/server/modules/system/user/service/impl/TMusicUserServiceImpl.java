package com.tangl.music.server.modules.system.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangl.music.core.exception.TMusicBusinessException;
import com.tangl.music.core.utils.IdUtil;
import com.tangl.music.server.common.enums.DelFlagEnum;
import com.tangl.music.server.common.enums.UserStatusEnum;
import com.tangl.music.server.common.page.PageResult;
import com.tangl.music.server.modules.system.role.vo.RoleVO;
import com.tangl.music.server.modules.system.user.context.*;
import com.tangl.music.server.modules.system.user.converter.UserConverter;
import com.tangl.music.server.modules.system.user.entity.TMusicUser;
import com.tangl.music.server.modules.system.user.mapper.TMusicUserMapper;
import com.tangl.music.server.modules.system.user.service.TMusicUserRoleService;
import com.tangl.music.server.modules.system.user.service.TMusicUserService;
import com.tangl.music.server.modules.system.user.vo.UserVO;
import com.tangl.music.server.security.utils.SecurityUtils;
import jakarta.annotation.Resource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author tangl
 * @description 用户业务层
 * @create 2023-12-21 23:27:58
 */
@Service
public class TMusicUserServiceImpl extends ServiceImpl<TMusicUserMapper, TMusicUser> implements TMusicUserService {

    @Resource
    private UserConverter converter;

    @Resource
    private TMusicUserRoleService userRoleService;

    /**
     * 注册用户
     *
     * @param context 上下文实体
     * @return userId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long register(RegisterUserContext context) {
        assembleUserEntity(context);
        TMusicUser entity = context.getEntity();
        try {
            if (!save(entity)) {
                throw new TMusicBusinessException("注册用户失败");
            }
            AddUserRoleContext addUserRoleContext = new AddUserRoleContext();
            addUserRoleContext.setUserId(entity.getUserId());
            addUserRoleContext.setRoleNameList(context.getRoleNameList());
            // 关联角色表
            userRoleService.add(addUserRoleContext);
        } catch (DuplicateKeyException e) {
            throw new TMusicBusinessException("用户名已存在");
        }
        return entity.getUserId();
    }

    /**
     * 删除用户
     *
     * @param context 上下文实体
     */
    @Override
    public void delete(DeleteUserContext context) {
        UpdateWrapper<TMusicUser> updateWrapper = Wrappers.update();
        updateWrapper.eq("user_id", context.getUserId());
        updateWrapper.set("del_flag", DelFlagEnum.YES.getCode());
        updateWrapper.set("update_by", new Date());
        updateWrapper.set("update_time", new Date());
        update(updateWrapper);
    }

    /**
     * 更新用户信息
     *
     * @param context 上下文实体
     */
    @Override
    public void update(UpdateUserContext context) {
        TMusicUser user = converter.updateUserContext2TMusicUser(context);
        user.setUpdateBy(0L);
        user.setUpdateTime(new Date());
        Integer count = baseMapper.updateUser(user);
        if (count == 0) {
            throw new TMusicBusinessException("更新用户信息失败");
        }
    }

    /**
     * 查询用户
     *
     * @param context 上下文实体
     */
    @Override
    public void queryPage(QueryUserContext context) {
        PageResult<UserVO> pageResult = context.getPageResult();
        Integer offset = pageResult.getOffset();
        Integer pageSize = pageResult.getPageSize();
        // 数据
        List<TMusicUser> userList = baseMapper.queryPage(context, offset, pageSize);
        List<UserVO> userVOList = converter.userList2UserVOList(userList);
        userVOList.forEach(userVO -> {
            List<RoleVO> roleVOList = userRoleService.queryRoleByUserId(userVO.getUserId());
            userVO.setRoleList(roleVOList);
        });
        // 行数
        Long count = baseMapper.count(context);
        pageResult.setTotal(count.intValue());
        pageResult.setRecords(userVOList);
    }

    /**
     * 更新用户角色
     *
     * @param context 上下文实体
     */
    @Override
    public void changeRole(ChangeRoleContext context) {
        userRoleService.changeRole(context);
    }

    /**
     * 根据用户名查询用户实体
     *
     * @param username 用户名
     * @return userVO
     */
    @Override
    public UserVO queryUserByUsername(String username) {
        QueryWrapper<TMusicUser> queryWrapper = Wrappers.query();
        queryWrapper.eq("username", username);
        queryWrapper.eq("del_flag", DelFlagEnum.NO.getCode());
        TMusicUser user = getOne(queryWrapper);
        if (Objects.isNull(user)) {
            throw new TMusicBusinessException("查询用户失败");
        }
        UserVO userVO = converter.user2UserVO(user);
        List<RoleVO> roles = userRoleService.queryRoleByUserId(user.getUserId());
        userVO.setRoleList(roles);
        return userVO;
    }

    /**
     * 组装用户实体
     *
     * @param context 上下文实体
     */
    private void assembleUserEntity(RegisterUserContext context) {
        TMusicUser entity = converter.registerUserContext2TMusicUser(context);
        entity.setUserId(IdUtil.get());
        entity.setPassword(SecurityUtils.encryptPassword(context.getPassword()));
        entity.setStatus(UserStatusEnum.ENABLE.getCode());
        entity.setCreateBy(0L);
        entity.setCreateTime(new Date());
        entity.setDelFlag(DelFlagEnum.NO.getCode());
        context.setEntity(entity);
    }
}
