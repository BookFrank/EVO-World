package com.tazine.evo.concurrent;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

/**
 * SpringBoot 2x
 *
 * @author frank
 * @date 2018/11/11
 */
//@ServletComponentScan
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(Application.class)
            //.profiles("dev")
            .run(args);

        System.err.println(JSON.toJSONString(context.getEnvironment()));
    }
}