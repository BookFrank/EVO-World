package com.tazine.evo.crontab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用启动类
 * @author frank
 * @date 2018/09/05
 */
@SpringBootApplication
public class TimedTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimedTaskApplication.class, args);
    }
}
