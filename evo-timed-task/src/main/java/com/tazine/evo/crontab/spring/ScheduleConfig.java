package com.tazine.evo.crontab.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

/**
 * 多线程执行定时任务 所有的定时任务都放在一个线程池中，定时任务启动时使用不同的线程
 *
 * @author jiaer.ly
 * @date 2018/09/06
 */
//@Configuration
public class ScheduleConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        // 设定一个长度为10的定长定时任务线程池
        scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(10));
    }
}
