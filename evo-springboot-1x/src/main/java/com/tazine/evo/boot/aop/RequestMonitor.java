package com.tazine.evo.boot.aop;

import java.lang.annotation.*;

/**
 * HTTP请求日志记录
 *
 * @author frank
 * @date 2019/05/15
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequestMonitor {
}
