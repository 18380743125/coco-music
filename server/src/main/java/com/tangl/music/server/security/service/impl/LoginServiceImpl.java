package com.tangl.music.server.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tangl.music.core.exception.TMusicBusinessException;
import com.tangl.music.server.modules.system.user.context.UserLoginContext;
import com.tangl.music.server.modules.system.user.entity.TMusicUser;
import com.tangl.music.server.modules.system.user.service.TMusicUserService;
import com.tangl.music.server.security.context.AuthenticationContextHolder;
import com.tangl.music.server.security.entity.LoginUser;
import com.tangl.music.server.security.service.LoginService;
import com.tangl.music.server.security.service.TokenService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author tangl
 * @description
 * @create 2023-12-26 18:48
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private TMusicUserService userService;

    @Resource
    private TokenService tokenService;

    @Override
    public String login(UserLoginContext context) {
        String username = context.getUsername();
        String password = context.getPassword();
        Authentication authentication;
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            AuthenticationContextHolder.setContext(authenticationToken);
            authentication = authenticationManager.authenticate(authenticationToken);
        } catch (Exception e) {
            throw new TMusicBusinessException("用户名或密码错误");
        } finally {
            AuthenticationContextHolder.clear();
        }
        // 获得登录用户对象信息，包含了其所拥有的权限信息
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        // 记录登录信息到数据库
        recordLoginInfo(loginUser.getUserId());
        // 生成token(也会同步把登录用户信息 loginUser 存进缓存中)
        return tokenService.createToken(loginUser);
    }

    /**
     * 记录登录信息
     *
     * @param userId 用户ID
     */
    public void recordLoginInfo(Long userId) {
        UpdateWrapper<TMusicUser> updateWrapper = Wrappers.update();
        updateWrapper.eq("user_id", userId);
        updateWrapper.set("login_ip", "");
        updateWrapper.set("login_date", new Date());
        userService.update(updateWrapper);
    }
}
