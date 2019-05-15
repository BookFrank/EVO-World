package com.tazine.evo.boot.aop;

import java.lang.annotation.*;

/**
 * 自定义AOP注解
 *
 * @author frank
 * @date 2019/05/15
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CustomAop {

}
