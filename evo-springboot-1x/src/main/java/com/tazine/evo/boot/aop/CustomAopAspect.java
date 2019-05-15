package com.tazine.evo.boot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 自定义注解切面
 *
 * @author frank
 * @date 2019/05/15
 */
@Aspect
@Component
public class CustomAopAspect {

    @Pointcut("@annotation(com.tazine.evo.boot.aop.CustomAop)")
    public void addAdvice() {}

    @Around("addAdvice()")
    public Object Interceptor(ProceedingJoinPoint pjp) {
        Object result = null;
        Object[] args = pjp.getArgs();
        if (args != null && args.length > 0) {
            String deviceId = (String)args[0];
            if (!"03".equals(deviceId)) {
                return "no anthorization";
            }
        }
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }
}
