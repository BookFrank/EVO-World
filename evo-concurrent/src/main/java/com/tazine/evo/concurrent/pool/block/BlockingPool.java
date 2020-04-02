package com.tazine.evo.concurrent.pool.block;

import lombok.SneakyThrows;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 队列满时，阻塞任务提交线程池，确保任务都能得到执行
 *
 * @author jiaer.ly
 * @date 2020/03/26
 */
public class BlockingPool {

    private static AtomicInteger ai = new AtomicInteger(5);

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue queue = new LinkedBlockingQueue(2);

        RejectedExecutionHandler rejectHandler = new BlockingRejectedExecutionHandler();
        //RejectedExecutionHandler rejectHandler = new ThreadPoolExecutor.CallerRunsPolicy();

        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 4, 5, TimeUnit.SECONDS, queue, rejectHandler);

        // 队列装不下了，就会创建新的线程
        for (int i = 1; i < 10; i++) {
            Runnable r = new Task(ai);
            pool.execute(r);
            System.out.println(i + " 号任务提交成功, poolSize=" + pool.getPoolSize());
            Thread.sleep(1000);
        }
    }

    public static class Task implements Runnable {

        private AtomicInteger ai;

        public Task(AtomicInteger ai) {
            this.ai = ai;
        }

        @SneakyThrows
        @Override
        public void run() {
            System.err.println(Thread.currentThread().getName() + " running, num=" + ai.getAndDecrement());
            TimeUnit.SECONDS.sleep(25);
            System.out.println("Hello World");
        }
    }

}
