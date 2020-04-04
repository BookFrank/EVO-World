package com.tazine.evo.concurrent.thread;

/**
 * sleep() 与 wait() 方法的区别
 *
 * @author frank
 * @date 2018/02/27
 */
public class SleepWaitDemo {

    public static void main(String[] args) {
        new Thread(new WaitThread()).start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(new SleepThread()).start();
    }

    private static class WaitThread implements Runnable{
        @Override
        public void run(){
            synchronized (SleepWaitDemo.class) {
                System.out.println("enter thread1...");
                System.out.println("thread1 is waiting...");
                try {
                    Thread.sleep(1000 * 3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    // 调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
                    SleepWaitDemo.class.wait();
                    //new Object().wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 is going on ....");
                System.out.println("thread1 is over!!!");
            }
        }
    }

    private static class SleepThread implements Runnable{
        @Override
        public void run(){
            System.out.println("enter thread2 run");
            synchronized (SleepWaitDemo.class) {
                System.out.println("enter thread2....");
                System.out.println("thread2 is sleep....");
                //只有针对此对象调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。
                SleepWaitDemo.class.notify();
                //new Object().notify();

                //==================
                //区别
                //如果我们把代码：TestD.class.notify();给注释掉，即TestD.class调用了wait()方法，但是没有调用notify()
                //方法，则线程永远处于挂起状态。
                try {
                    //sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，
                    //但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
                    //在调用sleep()方法的过程中，线程不会释放对象锁。
                    Thread.sleep(1000 * 5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 is going on....");
                System.out.println("thread2 is over!!!");
            }
        }
    }
}
