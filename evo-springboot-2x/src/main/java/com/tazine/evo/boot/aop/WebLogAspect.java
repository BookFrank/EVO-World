package com.tazine.evo.boot.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 统一日志切面
 *
 * @author frank
 * @date 2019/03/08
 */
@Slf4j
@Aspect
@Component
public class WebLogAspect {

    /**
     * 定义切入点，切入点为 com.tazine.evo.boot 下的所有函数
     */
    @Pointcut("execution(public * com.tazine.evo.boot.params.*.*(..))")
    public void webLog() {}

    /**
     * 前置通知：在连接点之前执行的通知
     *
     * @param joinPoint JoinPoint
     * @throws Throwable t
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature()
            .getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }
}
