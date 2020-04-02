package com.tazine.evo.concurrent.sync.synchronize;

/**
 * SyncDemo
 *
 * @author jiaer.ly
 * @date 2020/03/30
 */
public class SyncDemo {

    /**
     * 同步方法 A
     */
    public synchronized void syncMethodA() {
        System.out.println(Thread.currentThread().getName() + "线程，正在执行 syncMethodA");
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("syncMethodA done");
    }

    /**
     * 非同步方法 B
     */
    public void methodB() {
        System.out.println(Thread.currentThread().getName() + "线程，正在执行 methodB");
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("methodB done");
    }

    /**
     * 同步方法 C
     */
    public synchronized void syncMethodC() {
        System.out.println(Thread.currentThread().getName() + "线程，正在执行 syncMethodC");
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("syncMethodC done");
    }

    /**
     * 同步代码块方法 D，减少同步粒度，只同步需要同步的计算
     */
    public void syncMethodD() {
        try {
            synchronized (this){
                System.out.println(Thread.currentThread().getName() + "线程，正在执行 syncMethodD 中需要同步的部分");
                Thread.sleep(500);
            }

            // 使用线程休眠，模拟后续任务消耗
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("syncMethodD done");
    }
}
