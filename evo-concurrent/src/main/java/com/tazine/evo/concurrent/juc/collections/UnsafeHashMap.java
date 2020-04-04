package com.tazine.evo.concurrent.juc.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap 是线程不安全的
 *
 * @author jiaer.ly
 * @date 2020/04/04
 */
public class UnsafeHashMap {

    static Map<String, String> map = new HashMap<>();

    public static class PutTask implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                map.put(i + "", null);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new PutTask());
        Thread t2 = new Thread(new PutTask());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(map.size());
    }
}
