package com.tazine.evo.boot.retry.custom;

import java.lang.annotation.*;

/**
 * Retry
 *
 * @author frank
 * @date 2019/03/08
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Retry {

    int retryTimes() default 1;

}
