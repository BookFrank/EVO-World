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
    public Object interceptor(ProceedingJoinPoint pjp) {
        Object result = null;
        Object[] args = pjp.getArgs();
        System.out.println("进入 AOP");
        if (args != null && args.length > 0) {
            String param = (String)args[0];
            System.out.println("请求参数为：" + param);
        }
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("返回值为：" + result);
        return result;
    }
}
