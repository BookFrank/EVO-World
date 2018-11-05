package com.tazine.evo.async.jdk.singeleton;

import java.util.concurrent.TimeUnit;

/**
 * SingleBean 单例类
 *
 * @author frank
 * @date 2018/11/05
 */
public class SingleBean {

    private static SingleBean instance = new SingleBean();

    private SingleBean() {
    }

    public static SingleBean getInstance() {
        return instance;
    }

    public void exec() {
        System.out.println(Thread.currentThread().getName() + " 正在执行");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 执行完毕");
    }
}
