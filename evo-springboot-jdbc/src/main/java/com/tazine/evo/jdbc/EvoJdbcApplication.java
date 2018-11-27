package com.tazine.evo.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * SpringBoot2.x使用 Jdbc连接数据库
 *
 * @author frank
 * @date 2018/11/11
 */
@SpringBootApplication
public class EvoJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvoJdbcApplication.class, args);
    }
}
