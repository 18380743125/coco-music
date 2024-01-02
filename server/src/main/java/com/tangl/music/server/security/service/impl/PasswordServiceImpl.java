package com.tangl.music.server.security.service.impl;

import cn.hutool.core.text.StrFormatter;
import com.tangl.music.cache.redis.RedisCache;
import com.tangl.music.core.exception.TMusicBusinessException;
import com.tangl.music.server.modules.system.user.vo.UserVO;
import com.tangl.music.server.security.constants.SecurityConstants;
import com.tangl.music.server.security.context.AuthenticationContextHolder;
import com.tangl.music.server.security.service.PasswordService;
import com.tangl.music.server.security.utils.SecurityUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author tangl
 * @description
 * @create 2023-12-25 23:59
 */
@Service
public class PasswordServiceImpl implements PasswordService {

    @Resource
    private RedisCache redisCache;

    /**
     * 最大密码输错次数
     */
    @Value(value = "${user.password.max-retry-count}")
    private int maxRetryCount = 5;

    /**
     * 锁定时间，单位: 分钟
     */
    @Value(value = "${user.password.lock-time}")
    private int lockTime = 10;

    @Override
    public void validate(UserVO user) {
        Authentication authenticationToken = AuthenticationContextHolder.getContext();
        String username = authenticationToken.getName();
        String password = authenticationToken.getCredentials().toString();
        String retryCountKey = getCacheKey(username);
        // 从缓存中获取密码输错次数
        Integer retryCount = redisCache.getCacheObject(retryCountKey);
        if (retryCount == null) {
            retryCount = 0;
        }
        if (retryCount >= maxRetryCount) {
            throw new TMusicBusinessException(StrFormatter.format("已输错密码{}次，将锁定账号: {} {}分钟",
                    maxRetryCount, username, lockTime));
        }
        // 校验用户名密码
        if (!matches(user, password)) {
            retryCount++;
            redisCache.setCacheObject(retryCountKey, retryCount, lockTime, TimeUnit.MINUTES);
            throw new TMusicBusinessException(StrFormatter.format("已输错密码{}次，连续输错{}次将锁定账号{}分钟",
                    retryCount, maxRetryCount, lockTime));
        } else {
            // 输入正确清除密码尝试次数
            clearLoginRecordCache(retryCountKey);
        }
    }

    private void clearLoginRecordCache(String retryCountKey) {
        if (redisCache.hasKey(retryCountKey)) {
            redisCache.deleteObject(retryCountKey);
        }
    }

    private boolean matches(UserVO user, String rawPassword) {
        return SecurityUtils.matchesPassword(rawPassword, user.getPassword());
    }

    private String getCacheKey(String username) {
        return SecurityConstants.PASSWORD_ERROR_COUNT_KEY + username;
    }
}
