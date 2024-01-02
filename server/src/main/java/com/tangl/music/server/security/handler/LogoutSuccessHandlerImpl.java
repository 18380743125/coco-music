package com.tangl.music.server.security.handler;

import cn.hutool.core.text.StrFormatter;
import com.alibaba.fastjson2.JSON;
import com.tangl.music.core.response.R;
import com.tangl.music.server.security.entity.LoginUser;
import com.tangl.music.server.security.service.TokenService;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

/**
 * @author tangl
 * @description
 * @create 2023-12-26 21:49
 */
@Component
@Slf4j
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Resource
    private TokenService tokenService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (!Objects.isNull(loginUser)) {
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
        }
        String msg = StrFormatter.format("退出登录成功");
        String result = JSON.toJSONString(R.success(msg));
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(result);
        } catch (IOException e) {
            log.error("用户：{}，退出登录失败", loginUser.getUsername());
        }
    }
}
