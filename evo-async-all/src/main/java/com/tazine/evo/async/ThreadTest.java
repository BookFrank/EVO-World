package com.tazine.evo.async;

import java.util.concurrent.TimeUnit;

/**
 * ThreadTest
 *
 * @author frank
 * @date 2018/12/21
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Thread daemonThread = new Thread(() -> {
            try {
                while (true){
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println("Thread run");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();

        // 当主线程执行完成后，daemon线程会自动终止
        // java中的守护线程(Daemon Thread) 指的是一类特殊的Thread，其优先级特别低(低到甚至可以被JVM自动终止)，
        // 通常这类线程用于在空闲时做一些资源清理类的工作，比如GC线程，
        // 如果JVM中所有非守护线程（即：常规的用户线程）都结束了，守护线程会被JVM中止，
        // 想想其实也挺合理，没有任何用户线程了，自然也不会有垃圾对象产生，GC线程也没必要存在了。
        Thread.sleep(2000);
        System.out.println("Hello World");
    }
}
