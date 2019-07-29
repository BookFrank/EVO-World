package com.tazine.evo.boot.beanext.uda;

import java.lang.annotation.*;

/**
 * 自定义注解，作用类似 @Component
 *
 * @author frank
 * @date 2019/07/30
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface Tazine {
}
