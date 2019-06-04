package com.tazine.evo.boot;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * SpringBoot1.x
 *
 * @author frank
 * @date 2018/11/11
 */
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(Application.class)
            //.profiles("dev")
            .run(args);

        for (String b : context.getBeanDefinitionNames()){
            System.out.println(b + " - " + context.getBean(b).getClass());
        }

        System.err.println(JSON.toJSONString(context.getEnvironment()));
    }
}
