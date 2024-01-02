package com.tangl.music.swagger;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author tangl
 * @description
 * @create 2023-11-26 18:03
 */
@SpringBootConfiguration
public class SwaggerConfig {

    @Autowired
    private SwaggerConfigProperties properties;

    @Bean
    public OpenAPI swaggerOpenApi() {
        return new OpenAPI()
                .info(apiInfo())
                .externalDocs(new ExternalDocumentation()
                        .description("xxxx")
                        .url("xxx"));
    }

    private Info apiInfo() {
        return new Info()
                .title(properties.getTitle())
                .description(properties.getDescription())
                .version(properties.getVersion())
                .license(new License()
                        .name("许可协议")
                        .url("xxx"))
                .contact(contact())
                .termsOfService(properties.getTermsOfServiceURL());
    }

    public Contact contact() {
        return new Contact()
                .name(properties.getContactName())
                .url(properties.getContactUrl())
                .email(properties.getContactEmail());
    }
}