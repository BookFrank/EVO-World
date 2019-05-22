package com.tazine.evo.non;

import com.tazine.evo.non.service.FrankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot Gui CMD 应用
 *
 * @author frank
 * @date 2018/11/19
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Autowired
    private FrankService frankService;

    @Override
    public void run(String... args) throws Exception {
        frankService.sayHi();
        System.out.println("Run Done");
    }
}
