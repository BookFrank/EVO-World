package com.tazine.evo.async.concurrent;

/**
 * 同步阻塞
 *
 * @author jiaer.ly
 * @date 2018/03/20
 */
public class SyncBlocking {

    /**
     * 同步阻塞调用，简单理解就是在我执行方法的同时调用我的 Thread 必须在这等着，本方法没有执行完的时候是不会通知调用线程的
     *
     * @return string
     */
    public String exec() throws InterruptedException {
        // 线程 sleep 5s，模拟执行业务
        System.out.println(Thread.currentThread().getName() + "线程，exec 方法执行中必须等待本方法执行完");
        Thread.sleep(5000);

        // 在我这个方法没有 return 之前，调用的线程必须在这里傻傻地等待
        return "Hello From SyncBlocking";
    }
}
