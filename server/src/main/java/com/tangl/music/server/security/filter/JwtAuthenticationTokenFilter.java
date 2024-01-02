package com.tangl.music.server.security.filter;

import com.tangl.music.server.security.entity.LoginUser;
import com.tangl.music.server.security.service.TokenService;
import com.tangl.music.server.security.utils.SecurityUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

/**
 * token 过滤器 验证 token 有效性
 */
@Component
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        // 根据 token 从 redis 中获取登录用户上下文信息
        LoginUser loginUser = tokenService.getLoginUser(request);

        if (!Objects.isNull(loginUser) && Objects.isNull(SecurityUtils.getAuthentication())) {
            // 验证令牌有效期
            tokenService.verifyToken(loginUser);
            // 将用户安全信息存入 SecurityContextHolder, 在之后 SpringSecurity 的过滤器就不会拦截
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser,
                    null, loginUser.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        // 没有用户信息，需要从数据库中查
        // 放行
        filterChain.doFilter(request, response);
    }
}
