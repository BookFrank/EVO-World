package com.tazine.evo.spring.cmd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 应用启动时预先执行某些动作
 *
 * @author frank
 * @date 2018/11/01
 */
@Component
@Order(2)
public class MyFirstRunner implements CommandLineRunner {

    public void run(String... args) throws Exception {
        System.err.println("1. MyFirstRunner 执行");
    }
}
