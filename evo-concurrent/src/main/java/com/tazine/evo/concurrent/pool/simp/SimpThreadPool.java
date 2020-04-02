package com.tazine.evo.concurrent.pool.simp;

import lombok.SneakyThrows;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * SimpThreadPool
 *
 * @author jiaer.ly
 * @date 2020/03/26
 */
public class SimpThreadPool {

    private static AtomicInteger ai = new AtomicInteger(5);

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue queue = new LinkedBlockingQueue(2);

        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 4, 5, TimeUnit.SECONDS, queue);

        // 队列装不下了，就会创建新的线程
        for (int i = 1; i < 10; i++) {
            System.out.println(i + " 号任务提交成功 " + pool.getPoolSize());
            Runnable r = new Task(ai);
            pool.execute(r);
            Thread.sleep(2000);
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
            TimeUnit.DAYS.sleep(1);
            System.out.println("Hello World");
        }
    }
}
