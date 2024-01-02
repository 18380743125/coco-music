package com.tangl.music.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author tangl
 * @description
 * @create 2023-11-26 18:04
 */
@Data
@Component
@ConfigurationProperties(value = "swagger3")
public class SwaggerConfigProperties {

    private String groupName = "t-music";

    private String title = "t-music-server";

    private String description = "t-music-server";

    private String termsOfServiceURL = "http://tangl666.fun:8080";

    private String contactName = "tangl";

    private String contactUrl = "tangl666.fun";

    private String contactEmail = "tl-bright@163.com";

    private String version = "v1.0.0";
}
