package com.tazine.evo.crontab.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 简单 Spring Task 定时任务
 *
 * @author frank
 * @date 2018/09/05
 */
//@Configuration
//@EnableScheduling
public class SimpleSpringTask {

    @Scheduled(cron = "0/5 * * * * ?")
    public void schedule1() {
        System.out.println("Hello World -- " + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void schedule2() {
        System.out.println("Brave World -- " + Thread.currentThread().getName());
    }

    @Async
    @Scheduled(cron = "0/5 * * * * ?")
    public void schedule3() {
        System.out.println("Mad World -- " + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
