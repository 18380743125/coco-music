package com.tangl.music.server.security.handler;

import cn.hutool.core.text.StrFormatter;
import com.alibaba.fastjson2.JSON;
import com.tangl.music.core.response.R;
import com.tangl.music.core.response.ResponseCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author tangl
 * @description
 * @create 2023-12-26 21:48
 */
@Component
@Slf4j
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -8163079332175416160L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Integer code = ResponseCode.NEED_LOGIN.getCode();
        String msg = StrFormatter.format("请求访问:{}，认证失败，无法访问系统资源", request.getRequestURI());
        String result = JSON.toJSONString(R.fail(code, msg));
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(result);
        } catch (IOException e) {
            log.error("ServletUtils renderString exception message", e);
        }
    }
}
