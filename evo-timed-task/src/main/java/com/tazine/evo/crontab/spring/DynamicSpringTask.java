package com.tazine.evo.crontab.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;

/**
 * 动态定时任务
 *
 * @author jiaer.ly
 * @date 2018/09/05
 */
//@Configuration
//@EnableScheduling
public class DynamicSpringTask implements SchedulingConfigurer {

    public static String cron;

    public DynamicSpringTask() {
        // 默认情况：每5秒执行一次
        cron = "0/5 * * * * *";

        // 开启新线程，模拟外部更改了任务的执行周期
        new Thread(() -> {
            try {
                // 让线程睡眠 15秒
                Thread.sleep(15000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cron = "0/10 * * * * *";
            System.err.println("cron change to :" + cron);
        }).start();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        Runnable task = () -> {
            // 任务逻辑代码部分
            System.out.println("Cronjob us running ... " + new Date());
        };

        Trigger trigger = triggerContext -> {
            // 任务触发器，可修改任务的执行周期
            CronTrigger cronTrigger = new CronTrigger(cron);
            return cronTrigger.nextExecutionTime(triggerContext);
        };
        scheduledTaskRegistrar.addTriggerTask(task, trigger);
    }
}
