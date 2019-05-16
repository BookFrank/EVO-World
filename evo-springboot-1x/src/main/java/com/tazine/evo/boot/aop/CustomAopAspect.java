package com.tazine.evo.boot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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
    public void customPointCut() {}

    //声明前置通知
    @Before("customPointCut()")
    public void doBefore(){
        System.out.println("前置通知");
    }

    //后置通知，包括异常
    @After("customPointCut()")
    public void doAfter(){
        System.out.println("后置通知，包括异常");
    }

    //声明例外通知
    @AfterThrowing(pointcut="customPointCut()",throwing = "e")
    public void doAfterThrowing(Exception e){
        System.out.println("异常通知");
    }

    //声明后置通知
    @AfterReturning(pointcut="customPointCut()",returning="result")
    public void daAfterReturning(String result){
        System.out.println("后置通知，连接点完成，不包括异常： " + result);
    }

    /**
     * 声明环绕式通知
     *
     * @param pjp
     * @return
     */
    @Around("customPointCut()")
    public Object Interceptor(ProceedingJoinPoint pjp) {
        Object result = null;
        Object[] args = pjp.getArgs();
        System.out.println("环绕式通知");
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
