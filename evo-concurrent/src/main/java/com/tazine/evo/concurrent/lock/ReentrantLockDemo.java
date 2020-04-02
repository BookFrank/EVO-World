package com.tazine.evo.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLockDemo
 *
 * @author jiaer.ly
 * @date 2020/03/30
 */
public class ReentrantLockDemo {

    private ReentrantLock lock = new ReentrantLock();

    public void service1() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + ", invoke service1 method");
            Thread.sleep(1000 * 1);
            service2();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void service2() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + ", invoke service2 method");
            Thread.sleep(1000 * 1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        ReentrantLockDemo lockDemo = new ReentrantLockDemo();

        new Thread(() -> {
            lockDemo.service1();
        }).start();

        new Thread(() -> {
            lockDemo.service2();
        }).start();
    }

}
