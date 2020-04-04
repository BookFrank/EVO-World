package com.tazine.evo.concurrent.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ConditionDemo
 *
 * @author jiaer.ly
 * @date 2020/03/20
 */
public class ConditionTask implements Runnable{

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println("Thread is going on");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionTask task = new ConditionTask();
        Thread thread = new Thread(task);

        thread.start();

        Thread.sleep(2000);
        // 通知 thread 线程继续执行
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
