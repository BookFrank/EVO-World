package com.tazine.evo.async.spring;

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

    /**
     * 核心线程数
     */
    private int corePoolSize = 10;

    /**
     * 最大线程数
     */
    private int maxPoolSize = 20;

    /**
     * 队列长度
     */
    private int queueCapacity = 100;

    @Bean(name = "task-pool-1")
    public Executor asyncExecutor() {
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
}
