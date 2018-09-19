package com.tazine.evo.annotation.context;

import com.tazine.evo.annotation.EvoSpringbootAnnotationApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 注解配置应用上下文
 *
 * @author frank
 * @date 2018/09/19
 */
public class AnnotationContext {

    public static void main(String[] args) {
        // AnnotationConfigApplicationContext 作为 Spring 容器，接受输入一个配置类作为参数启动容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            EvoSpringbootAnnotationApplication.class);

        // 测试 Bean 的 scope
        //for (int i = 0; i < 10; i++) {
        //    ScopeService scopeService = (ScopeService)context.getBean("scopeService");
        //    scopeService.test();
        //}

        // 测试加载了哪些 Bean
        //NoScanService noScanService = context.getBean(NoScanService.class);
        //noScanService.test();
    }
}
