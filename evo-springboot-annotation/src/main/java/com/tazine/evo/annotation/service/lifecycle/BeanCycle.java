package com.tazine.evo.annotation.service.lifecycle;

/**
 * 通过@Bean实现的 Bean 生命周期
 *
 * @author frank
 * @date 2018/09/19
 */
public class BeanCycle {

    public void init() {
        System.out.println("init method run");
    }

    public BeanCycle() {
        System.out.println("constructor run");
    }

    public void destroy() {
        System.out.println("destory method run");
    }
}
