package com.tangl.music.server;

import com.tangl.music.core.constants.CoCoMusicConstants;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = CoCoMusicConstants.BASE_COMPONENT_SCAN_PATH)
@ServletComponentScan(basePackages = CoCoMusicConstants.BASE_COMPONENT_SCAN_PATH)
@MapperScan(basePackages = CoCoMusicConstants.BASE_COMPONENT_SCAN_PATH + ".server.modules.**.mapper")
@EnableTransactionManagement
@EnableAsync
public class MusicServerLauncher {
    public static void main(String[] args) {
        SpringApplication.run(MusicServerLauncher.class);
    }
}
