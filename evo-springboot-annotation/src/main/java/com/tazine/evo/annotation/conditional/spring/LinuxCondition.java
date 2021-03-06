package com.tazine.evo.annotation.conditional.spring;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判定 Linux 的条件
 *
 * @author frank
 * @date 2018/09/26
 */
public class LinuxCondition implements Condition {

    /**
     * matches
     *
     * @param context  context
     * @param metadata 获得当前配置类上的注解
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.err.println("LinuxCondition: " + context.getEnvironment().getProperty("os.name"));
        return context.getEnvironment().getProperty("os.name").contains("Linux");
    }
}
