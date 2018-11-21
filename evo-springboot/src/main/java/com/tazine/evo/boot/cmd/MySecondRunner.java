package com.tazine.evo.boot.cmd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * MySecondRunner
 *
 * @author frank
 * @date 2018/11/01
 */
@Component
@Order(1)
public class MySecondRunner implements CommandLineRunner{

    public void run(String... args) throws Exception {
        System.err.println("2. MySecondRunner 执行");
    }
}
