package com.tazine.evo.concurrent.lock;

/**
 * DeadLockDemo
 *
 * @author jiaer.ly
 * @date 2020/03/30
 */
public class DeadLockDemo {

    private Object monitorOne = new Object();

    private Object monitorTwo = new Object();

    public void method1() {
        synchronized (monitorOne) {
            System.out.println(Thread.currentThread().getName() + " 执行锁住 monitorOne 的同步代码块");
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (monitorTwo) {
                System.out.println(Thread.currentThread().getName() + " 执行锁住 monitorTwo 的同步代码块");
            }
        }
    }

    public void method2() {
        synchronized (monitorTwo) {
            System.out.println(Thread.currentThread().getName() + " 执行锁住 monitorTwo 的同步代码块");
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (monitorOne) {
                System.out.println(Thread.currentThread().getName() + " 执行锁住 monitorOne 的同步代码块");
            }
        }
    }

    public static void main(String[] args) {

        DeadLockDemo deadLockDemo = new DeadLockDemo();

        new Thread(() -> {
            deadLockDemo.method1();
        }).start();

        new Thread(() -> {
            deadLockDemo.method2();
        }).start();
    }
}
