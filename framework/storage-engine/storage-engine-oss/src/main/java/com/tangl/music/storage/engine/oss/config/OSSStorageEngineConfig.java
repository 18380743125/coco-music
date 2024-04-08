package com.tangl.music.storage.engine.oss.config;

import com.aliyun.oss.OSSClient;
import com.tangl.pan.core.exception.TPanFrameworkException;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author tangl
 * @description OSS文件存储引擎配置类
 * @create 2023-09-12 22:07
 */
@Component
@Data
@ConfigurationProperties(value = "com.tangl.pan.storage.engine.oss")
public class OSSStorageEngineConfig {

    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;

    private String bucketName;

    private Boolean autoCreateBucket = Boolean.TRUE;

    /**
     * 注入OSS操作客户端对象
     *
     * @return OSSClient
     */
    @Bean(destroyMethod = "shutdown")
    public OSSClient ossClient() {
        if (StringUtils.isAnyBlank(getEndpoint(), getAccessKeyId(), getAccessKeySecret(), getBucketName())) {
            throw new TPanFrameworkException("the oss config is missed!");
        }
        return new OSSClient(getEndpoint(), getAccessKeyId(), getAccessKeySecret());
    }
}
