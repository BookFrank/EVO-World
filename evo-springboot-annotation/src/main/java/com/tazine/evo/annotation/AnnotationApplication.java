package com.tazine.evo.annotation;

import com.tazine.evo.noscan.NoScanConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * SpringBoot 各类注解学习启动类
 *
 * @author frank
 * @date 2018/09/15
 */
@ComponentScan("com.tazine.evo.annotation")
@Import(NoScanConfiguration.class)
@SpringBootApplication
public class AnnotationApplication {

    public static void main(String[] args) {

        start1(args, AnnotationApplication.class);


        //start2(args);

        //start3(args);
    }

    /**
     * 基于 SpringApplication 的静态run方法的应用启动
     *
     * @param args 命令行参数
     */
    private static void start1(String[] args, Class clz) {
        SpringApplication.run(clz, args);
    }

    /**
     * 基于 SpringApplicationBuild 实例run方法的应用启动
     *
     * @param args 命令行参数
     */
    private static void start2(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(AnnotationApplication.class)
            .profiles("dev")
            .run(args);
    }

    private static void start3(String[] args) {
        SpringApplication app = new SpringApplication(AnnotationApplication.class);
        app.setBanner(null);
        app.run(args);
    }

}
