package com.tazine.evo.concurrent.pool.priority;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 队列满时，阻塞任务提交线程池，确保任务都能得到执行
 *
 * @author jiaer.ly
 * @date 2020/03/26
 */
public class PriorityPool {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue queue = new PriorityBlockingQueue(10);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 4, 5, TimeUnit.SECONDS, queue);

        // 队列装不下了，就会创建新的线程
        for (int i = 1; i < 10; i++) {
            String name = "thread-" + i;
            Runnable r = new MyPriorityTask(name, i);
            pool.execute(r);
            System.out.println(i + " 号任务提交成功, poolSize=" + pool.getPoolSize());
        }
    }
}
