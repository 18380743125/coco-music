package com.tangl.music.cache.caffine.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.tangl.music.cache.core.constants.CacheConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;

/**
 * @author tangl
 * @description
 * @create 2023-11-25 22:22
 */
@Slf4j
public class CaffeineCacheConfig {

    @Autowired
    private CaffeineCacheProperties properties;

    @Bean
    public CacheManager caffeineCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager(CacheConstants.T_MUSIC_CACHE_NAME);
        cacheManager.setAllowNullValues(properties.getAllowNullValue());
        Caffeine<Object, Object> caffeineBuilder = Caffeine.newBuilder()
                .initialCapacity(properties.getInitCacheCapacity())
                .maximumSize(properties.getMaxCacheCapacity());
        cacheManager.setCaffeine(caffeineBuilder);
        log.info("the caffeine cache manager has loaded successfully!");
        return cacheManager;
    }
}
