package com.tazine.evo.ehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

/**
 * SpringBoot2.x与 EhCache3.x 整合
 *
 * @author frank
 * @date 2018/11/11
 */
@ServletComponentScan
@EnableCaching
@SpringBootApplication
public class EvoEhCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvoEhCacheApplication.class, args);
    }
}
