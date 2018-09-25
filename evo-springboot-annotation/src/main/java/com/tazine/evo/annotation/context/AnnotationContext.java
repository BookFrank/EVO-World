package com.tazine.evo.annotation.context;

import com.tazine.evo.annotation.EvoSpringBootAnnotationApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * 注解配置应用上下文
 *
 * @author frank
 * @date 2018/09/19
 */
public class AnnotationContext {

    public static void main(String[] args) {

        app(args);

        // AnnotationConfigApplicationContext 作为 Spring 容器，接受输入一个配置类作为参数启动容器
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        //    EvoSpringbootAnnotationApplication.class);

        //System.err.println(Arrays.toString(context.getEnvironment().getActiveProfiles()));
        // 测试 Bean 的 scope
        //for (int i = 0; i < 10; i++) {
        //    ScopeService scopeService = (ScopeService)context.getBean("scopeService");
        //    scopeService.test();
        //}

        // 测试加载了哪些 Bean
        //NoScanService noScanService = context.getBean(NoScanService.class);
        //noScanService.test();
    }

    private static void app(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        System.err.println(Arrays.toString(context.getEnvironment().getActiveProfiles()));
        // 先设置活动Profile，再注册 Bean 配置类，然后刷新容器
        // 通过设定 Environment 的 ActiveProfiles 来设定当前 context 需要使用的配置环境
        context.getEnvironment().setActiveProfiles("dev");
        System.err.println(Arrays.toString(context.getEnvironment().getActiveProfiles()));
        context.register(EvoSpringBootAnnotationApplication.class);
        context.refresh();

        context.close();

        System.err.println(Arrays.toString(context.getEnvironment().getActiveProfiles()));
    }
}
