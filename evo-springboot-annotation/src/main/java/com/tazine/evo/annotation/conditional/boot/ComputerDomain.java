package com.tazine.evo.annotation.conditional.boot;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * ComputerDomain
 *
 * @author frank
 * @date 2019/05/01
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(ComputerDomainCondition.class)
public @interface ComputerDomain {
    String domain() default "local";
}
