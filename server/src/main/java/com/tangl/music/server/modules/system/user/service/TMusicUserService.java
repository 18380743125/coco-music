package com.tangl.music.server.modules.system.user.service;

import com.tangl.music.server.modules.system.user.entity.TMusicUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tangl.music.server.modules.system.user.context.*;
import com.tangl.music.server.modules.system.user.vo.UserVO;

/**
 * @author tangl
 * @description 用户业务层
 * @create 2023-12-21 23:27:58
 */
public interface TMusicUserService extends IService<TMusicUser> {

    /**
     * 注册用户
     *
     * @param context 上下文实体
     * @return userId
     */
    Long register(RegisterUserContext context);

    /**
     * 删除用户
     *
     * @param context 上下文实体
     */
    void delete(DeleteUserContext context);

    /**
     * 更新用户信息
     *
     * @param context 上下文实体
     */
    void update(UpdateUserContext context);

    /**
     * 查询用户
     *
     * @param context 上下文实体
     */
    void queryPage(QueryUserContext context);

    /**
     * 更新用户角色
     *
     * @param context 上下文实体
     */
    void changeRole(ChangeRoleContext context);

    /**
     * 根据用户名查询用户实体
     *
     * @param username 用户名
     */
    UserVO queryUserByUsername(String username);
}
