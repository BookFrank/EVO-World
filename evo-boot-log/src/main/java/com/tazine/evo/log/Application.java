package com.tazine.evo.log;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * SpringBoot Log
 *
 * @author frank
 * @date 2018/11/11
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(Application.class)
            //.profiles("dev")
            .run(args);

        for (String b : context.getBeanDefinitionNames()){
            //System.out.println(b + " - " + context.getBean(b).getClass());
        }

        System.err.println(JSON.toJSONString(context.getEnvironment()));
    }
}
