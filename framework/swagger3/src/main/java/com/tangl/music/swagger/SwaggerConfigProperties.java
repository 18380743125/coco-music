package com.tangl.music.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * swagger配置属性实体
 */
@Data
@Component
@ConfigurationProperties(value = "swagger")
public class SwaggerConfigProperties {

    private String title = "Your title";

    private String description = "Your description";

    private String termsOfServiceUrl = "你的API服务条款地址";

    private String contactName = "Your contact name";

    private String contactUrl = "Your contact url";

    private String contactEmail = "Your contact email";

    private String licenseName = "Your license name";

    private String licenseUrl = "Your license url";

    private String licenseIdentifier = "Your license identifier";

    private String version="1.0";
}
