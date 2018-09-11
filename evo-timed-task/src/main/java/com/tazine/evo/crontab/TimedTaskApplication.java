package com.tazine.evo.crontab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 应用启动类
 *
 * @author frank
 * @date 2018/09/05
 */
@EnableAsync
@SpringBootApplication
public class TimedTaskApplication {

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(TimedTaskApplication.class)
            .run(args);
        for (String s : context.getBeanDefinitionNames()){
            //System.out.println(s + " -- " + context.getBean(s).getClass().getName());
        }
    }
}
