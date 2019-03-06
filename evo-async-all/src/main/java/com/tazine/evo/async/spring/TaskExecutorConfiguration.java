package com.tazine.evo.async.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Spring 线程池配置方法-1
 *
 * @author frank
 * @date 2018/09/26
 */
@EnableAsync
@Configuration
public class TaskExecutorConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(TaskExecutorConfiguration.class);

    /**
     * 核心线程数
     */
    private int corePoolSize = 2;

    /**
     * 最大线程数
     */
    private int maxPoolSize = 4;

    /**
     * 队列长度
     */
    private int queueCapacity = 5;

    @Bean(name = "task-pool-1")
    public ThreadPoolTaskExecutor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix("tazine-exec-");

        // CALLER_RUNS：当pool达到max size的时候，不在新线程中执行任务，而是有调用者所在的线程来执行，这个策略重试添加当前的任务，他会自动重复调用 execute() 方法，直到成功
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // DiscardOldestPolicy：对拒绝任务不抛弃，而是抛弃队列里面等待最久的一个线程，然后把拒绝任务加到队列。
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        // DiscardPolicy：对拒绝任务直接无声抛弃，没有异常信息。
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        // AbortPolicy：对拒绝任务抛弃处理，并且抛出异常。
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

        executor.initialize();
        return executor;
    }

    @Bean(name = "async-service")
    //public Executor asyncServiceExecutor() {
    public ThreadPoolTaskExecutor asyncServiceExecutor() {
        logger.info("start asyncServiceExecutor");
        //使用VisiableThreadPoolTaskExecutor
        ThreadPoolTaskExecutor executor = new VisiableThreadPoolExecutor();
        //配置核心线程数
        executor.setCorePoolSize(5);
        //配置最大线程数
        executor.setMaxPoolSize(5);
        //配置队列大小
        executor.setQueueCapacity(99999);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("visiable-async-");

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}
