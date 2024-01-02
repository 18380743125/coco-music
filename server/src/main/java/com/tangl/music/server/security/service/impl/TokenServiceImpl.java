package com.tangl.music.server.security.service.impl;

import com.tangl.music.cache.redis.RedisCache;
import com.tangl.music.core.exception.TMusicBusinessException;
import com.tangl.music.core.utils.JwtUtil;
import com.tangl.music.core.utils.UUIDUtil;
import com.tangl.music.server.security.constants.SecurityConstants;
import com.tangl.music.server.security.entity.LoginUser;
import com.tangl.music.server.security.service.TokenService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author tangl
 * @description
 * @create 2023-12-26 20:39
 */
@Service
@Slf4j
public class TokenServiceImpl implements TokenService {

    // 令牌自定义标识
    @Value("${token.header}")
    private String header = "Authorization";

    // 令牌秘钥
    @Value("${token.secret}")
    private String secret = "N9jPYCXrwkuFIswmhb/VJJ3pHlmK5R3leA6PlDS7XXJv9hftWfuDZD2rfHb1z6qPgIuMx2UvG91/ayBjNskHBg";

    /**
     * 令牌有效期（默认1小时）, 单位为分钟
     */
    @Value("${token.expire-time}")
    private Integer expireTime = 60;

    // jwt签发者
    @Value("${token.iss}")
    private String iss = "Jwt iss";

    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

    @Resource
    private RedisCache redisCache;

    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    @Override
    public LoginUser getLoginUser(HttpServletRequest request) {
        // 获取请求携带的令牌
        String token = getToken(request);
        if (StringUtils.isNotEmpty(token)) {
            // token存在，但是解析出错，会报过期错误，否则不进行处理
            try {
                // 获取到uuid
                String uuid = JwtUtil.parseUUId(token, secret, SecurityConstants.LOGIN_USER_KEY);
                // 解析对应的权限以及用户信息
                String userKey = getTokenKey(uuid);
                return redisCache.getCacheObject(userKey);
            } catch (Exception e) {
                log.error(e.toString());
                throw new TMusicBusinessException("token 解析出错");
            }
        }
        return null;
    }

    /**
     * 根据登录用户名和用户id创建token
     *
     * @param loginUser 用户信息
     * @return 令牌
     */
    @Override
    public String createToken(LoginUser loginUser) {
        // 令牌id
        String uuid = UUIDUtil.getUUID();
        // 生成不带过期时间的 token
        String token = JwtUtil.generateToken(
                iss,
                loginUser.getUsername(),
                SecurityConstants.LOGIN_USER_KEY,
                uuid,
                secret);
        loginUser.setToken(uuid);
        setUserAgent(loginUser);
        refreshToken(loginUser);
        return token;
    }

    /**
     * 删除用户身份信息
     */
    @Override
    public void delLoginUser(String token) {
        if (StringUtils.isNotEmpty(token)) {
            String userKey = getTokenKey(token);
            redisCache.deleteObject(userKey);
        }
    }

    /**
     * 验证令牌有效期，相差不足20分钟，自动刷新缓存
     *
     * @param loginUser 登录用户
     */
    public void verifyToken(LoginUser loginUser) {
        long expireTime = loginUser.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= MILLIS_MINUTE_TEN) {
            refreshToken(loginUser);
        }
    }

    /**
     * 刷新令牌有效期
     *
     * @param loginUser 登录信息
     */
    public void refreshToken(LoginUser loginUser) {
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + expireTime * MILLIS_MINUTE);
        log.info("当前登录用户信息: " + loginUser);
        // 根据 uuid 将 loginUser 缓存
        String userKey = getTokenKey(loginUser.getToken());
        redisCache.setCacheObject(userKey, loginUser, expireTime, TimeUnit.MINUTES);
    }

    /**
     * 设置用户代理信息
     *
     * @param loginUser 登录信息
     */
    public void setUserAgent(LoginUser loginUser) {
        // UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        // String ip = IpUtils.getIpAddr();
        // loginUser.setIpaddr(ip);
        // loginUser.setLoginLocation(AddressUtils.getRealAddressByIP(ip));
        // loginUser.setBrowser(userAgent.getBrowser().getName());
        // loginUser.setOs(userAgent.getOperatingSystem().getName());
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        return JwtUtil.parseUsername(token, secret);
    }

    /**
     * 获取请求token
     *
     * @param request 请求对象
     * @return token
     */
    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(header);
        if (StringUtils.isNotEmpty(token) && token.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            token = token.replace(SecurityConstants.TOKEN_PREFIX, "");
        }
        return token;
    }

    private String getTokenKey(String uuid) {
        return SecurityConstants.LOGIN_INFO_KEY + uuid;
    }
}
