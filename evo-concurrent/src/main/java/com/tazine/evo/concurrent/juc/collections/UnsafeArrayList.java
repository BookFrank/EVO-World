package com.tazine.evo.concurrent.juc.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList 是非线程安全的
 *
 * @author jiaer.ly
 * @date 2020/04/04
 */
public class UnsafeArrayList {

    static List<Integer> list = new ArrayList<>();

    public static class AddTask implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                list.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AddTask());
        Thread t2 = new Thread(new AddTask());
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // 程序抛出异常，因为 ArrayList 在扩容过程中，内部一致性被批换，但由于没有锁的保护

        Thread.sleep(1000 * 5);
        System.out.println(list.size());
    }
}
