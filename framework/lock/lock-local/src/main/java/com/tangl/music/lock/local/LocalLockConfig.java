package com.tangl.music.lock.local;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.locks.DefaultLockRegistry;
import org.springframework.integration.support.locks.LockRegistry;

@SpringBootConfiguration
@Slf4j
public class LocalLockConfig {

    /**
     * 配置本地锁注册器
     */
    @Bean
    public LockRegistry localLockRegistry() {
        LockRegistry lockRegistry = new DefaultLockRegistry();
        log.info("the local lock is loaded successfully");
        return lockRegistry;
    }

}