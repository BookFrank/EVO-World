package com.tazine.evo.concurrent.sync;

import java.util.concurrent.TimeUnit;

/**
 * Test
 *
 * @author jiaer.ly
 * @date 2020/03/29
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        //nonShareableDataThreadRun();

        shareableDataThreadRun();
    }

    /**
     * 共享数据就是指多个线程可以访问同一个变量，多线程并发访问同一个资源时，那么一定会出现非线程安全的问题
     */
    private static void shareableDataThreadRun() throws InterruptedException {
        Integer count = 5;
        for (int i = 0; i < 5; i++) {
            Thread thread = new ShareableThread(count, i + "");
            thread.start();
        }
        TimeUnit.SECONDS.sleep(10);
        System.out.println(count);
    }

    /**
     * 共享数据就是指多个线程可以访问同一个变量，多线程并发访问同一个资源时，那么一定会出现非线程安全的问题
     */
    private static void shareableDataTaskRun() {
        Integer count = 5;
        Runnable task = new ShareableTask(count);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(task, i + "");
            thread.start();
        }
    }

    /**
     * 不共享数据的线程，实例变量不对其他线程共享，该实例变量所有操作都有这一个线程完成，因此不存在线程不安全
     */
    private static void nonShareableDataThreadRun() {
        for (int i = 0; i < 3; i++) {
            NonShareableThread thread = new NonShareableThread(i + "");
            thread.start();
        }
    }
}
