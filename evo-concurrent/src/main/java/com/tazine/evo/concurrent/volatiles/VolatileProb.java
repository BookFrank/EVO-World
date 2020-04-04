package com.tazine.evo.concurrent.volatiles;

/**
 * volatile 无法保证复合操作 i++ 的原子性
 *
 * @author jiaer.ly
 * @date 2020/04/04
 */
public class VolatileProb {

    static volatile int i = 0;

    public static class PlusTask implements Runnable {
        @Override
        public void run() {
            for (int k = 0; k < 10000; k++) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new PlusTask());
            threads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }

        Thread.sleep(1000 * 5);
        System.out.println(i);
        // 得到的并不是期待的结果
    }
}
