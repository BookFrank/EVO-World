package com.tazine.evo.crontab.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Quartz 任务
 *
 * @author frank
 * @date 2018/09/07
 */
public class HelloJob implements Job {

    /**
     * 具体任务执行逻辑
     *
     * @param jobExecutionContext JobExecutionContext
     * @throws JobExecutionException e
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(Thread.currentThread().getName() + " HelloJob Start, " + new Date());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " HelloJob End, " + new Date());
    }

    public static void main(String[] args) throws SchedulerException, InterruptedException {

        /*
         * 在 Quartz 中，scheduler 由 scheduler 工厂创建：DirectSchedulerFactory 或 StdSchedulerFactory
         * StdSchedulerFactory 使用较多，DirectSchedulerFactory 使用需要许多详细的手工编码设置
         */
        // 获取 Scheduler 实例
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();

        System.out.println("scheduler.start");

        // 具体执行任务
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").build();

        // 具体触发时间点
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1").startNow().withSchedule(simpleScheduleBuilder).build();

        // 交由 scheduler 安排触发
        scheduler.scheduleJob(jobDetail, trigger);

        // 睡眠20s
        TimeUnit.SECONDS.sleep(200);
        scheduler.shutdown();
        System.out.println("scheduler.shundown");

        // 默认多线程执行，满足任务触发条件自动起线程开始执行， 不管上次任务有没有结束
    }
}
