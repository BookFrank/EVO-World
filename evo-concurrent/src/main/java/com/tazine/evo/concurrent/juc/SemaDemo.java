package com.tazine.evo.concurrent.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * SemaDemo
 *
 * @author jiaer.ly
 * @date 2020/04/04
 */
public class SemaDemo implements Runnable {

    final Semaphore semp = new Semaphore(5);

    @Override
    public void run() {
        try {
            semp.acquire();
            Thread.sleep(1000 * 2);
            System.out.println(Thread.currentThread().getName() + " done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semp.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(20);
        final SemaDemo task = new SemaDemo();
        for (int i = 0; i < 20; i++) {
            pool.submit(task);
        }
    }
}
