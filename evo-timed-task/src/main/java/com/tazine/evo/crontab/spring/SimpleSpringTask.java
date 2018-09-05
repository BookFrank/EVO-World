package com.tazine.evo.crontab.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 简单 Spring Task 定时任务
 *
 * @author jiaer.ly
 * @date 2018/09/05
 */
@Configuration
@EnableScheduling
public class SimpleSpringTask {

    @Scheduled(cron = "0/5 * * * * ?")
    public void schedule() {
        //System.out.println("Hello World");
    }
}
