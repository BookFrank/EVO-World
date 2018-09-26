package com.tazine.evo.annotation.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * MacCondition
 *
 * @author frank
 * @date 2018/09/26
 */
public class MacCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.err.println("MacCondition: " + context.getEnvironment().getProperty("os.name"));
        return context.getEnvironment().getProperty("os.name").contains("Mac");
    }
}
