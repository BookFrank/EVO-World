package com.tazine.evo.async;

/**
 * @author jiaer.ly
 * @date 2018/12/21
 */
public class ThreadTest {

    public static void main(String[] args) {
        Thread.currentThread().setDaemon(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("Hello World");
    }

}
