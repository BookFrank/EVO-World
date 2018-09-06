package com.tazine.evo.crontab.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

/**
 * @author jiaer.ly
 * @date 2018/09/05
 */
@RestController
@Component
public class DynamicTask {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture<?> future;

    //@Bean
    //public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
    //    return new ThreadPoolTaskScheduler();
    //}

    @RequestMapping("/startCron")
    public String startCron(){
        future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger("0/5 * * * * *"));
        System.out.println("start a new cronjob");
        return "startCron";
    }

    @RequestMapping("/stopCron")
    public String stopCron(){
        if (null != future){
            future.cancel(true);
        }
        System.out.println("stop cron success");
        return "stopCron";
    }

    @Async
    public void testAsync(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("UserDefined task run, " + new Date() + " -- " + Thread.currentThread().getName());
            testAsync();
        }
    }
}

