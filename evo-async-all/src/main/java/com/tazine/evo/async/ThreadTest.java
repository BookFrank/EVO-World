package com.tazine.evo.async;

/**
 * ThreadTest
 *
 * @author frank
 * @date 2018/12/21
 */
public class ThreadTest {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    System.out.println("Thread run");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("Hello World");
        Thread.currentThread().setDaemon(true);
    }
}
