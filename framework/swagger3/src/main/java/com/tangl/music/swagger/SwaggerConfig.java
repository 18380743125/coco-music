package com.tangl.music.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * 接口文档配置类
 */
@Configuration
@Log4j2
public class SwaggerConfig {
    @Resource
    private SwaggerConfigProperties properties;

    @Bean
    public OpenAPI springShopOpenAPI() {
        // 构建API的联系人信息
        Contact contact = new Contact()
                .name(properties.getContactName()) // 文档的发布者名称
                .email(properties.getContactEmail()) // 文档发布者的网站地址,一般为企业网站
                .url(properties.getContactUrl()) // email：文档发布者的电子邮箱
                .extensions(new HashMap<String, Object>()); // 使用Map配置信息(如key为"name","email","url")

        // 授权许可信息(license)，包括名称、URL等；假设当前的授权信息为Apache 2.0的开源标准
        License license = new License()
                .name(properties.getLicenseName())  // 授权名称
                .url(properties.getLicenseUrl())  // 授权信息
                .identifier(properties.getLicenseIdentifier())  // 授权许可标识
                .extensions(new HashMap<String, Object>());// 使用Map配置信息(如key为"name","url","identifier")

        //创建Api帮助文档的描述信息、联系人信息(contact)、授权许可信息(license)
        Info info = new Info()
                .title(properties.getTitle())  // Api接口文档标题(必填)
                .description(properties.getDescription()) // Api接口文档描述
                .termsOfService(properties.getTermsOfServiceUrl())  // Api接口的服务条款地址
                .contact(contact)  // 设置联系人信息
                .license(license)  // 授权许可信息
                .version(properties.getVersion());  // Api接口版本

        OpenAPI api = new OpenAPI()
                .info(info);
//                .externalDocs(new ExternalDocumentation()
//                        .description("外部文档")
//                        .url("https://springshop.wiki.github.org/docs"));

        log.info("The swagger have been loaded successfully!");
        return api;
    }


}
