package com.tazine.evo.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringBoot 各类注解学习启动类
 *
 * @author frank
 * @date 2018/09/15
 */
@ComponentScan("com.tazine.evo")
@SpringBootApplication
public class EvoSpringBootAnnotationApplication {

    public static void main(String[] args) {
        //start1(args);

        start2(args);
    }

    /**
     * 基于 SpringApplication 的静态run方法的应用启动
     *
     * @param args 命令行参数
     */
    private static void start1(String[] args) {
        SpringApplication.run(EvoSpringBootAnnotationApplication.class, args);
    }

    /**
     * 基于 SpringApplicationBuild 实例run方法的应用启动
     *
     * @param args 命令行参数
     */
    private static void start2(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(EvoSpringBootAnnotationApplication.class)
            .profiles("dev")
            .run(args);
    }
}
