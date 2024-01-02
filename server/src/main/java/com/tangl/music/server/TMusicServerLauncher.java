package com.tangl.music.server;

import com.tangl.music.core.constants.TMusicConstants;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author tangl
 * @description 服务启动类
 * @create 2023-11-25 17:47
 */
@SpringBootApplication(scanBasePackages = TMusicConstants.BASE_COMPONENT_SCAN_PATH)
@ServletComponentScan(basePackages = TMusicConstants.BASE_COMPONENT_SCAN_PATH)
@MapperScan(basePackages = TMusicConstants.BASE_COMPONENT_SCAN_PATH + ".server.modules.**.mapper")
@EnableTransactionManagement
@EnableAsync
public class TMusicServerLauncher {
    public static void main(String[] args) {
        SpringApplication.run(TMusicServerLauncher.class);
    }
}
