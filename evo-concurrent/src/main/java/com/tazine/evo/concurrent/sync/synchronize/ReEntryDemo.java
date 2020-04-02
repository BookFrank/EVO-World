package com.tazine.evo.concurrent.sync.synchronize;

/**
 * synchronized 可重入
 *
 * @author jiaer.ly
 * @date 2020/03/30
 */
public class ReEntryDemo {

    public synchronized void service1(){
        System.out.println(Thread.currentThread().getName() +  ", invoke service1 method");
        service2();
    }

    public synchronized void service2(){
        System.out.println(Thread.currentThread().getName() +  ", invoke service2 method");
        service3();
    }

    public synchronized void service3(){
        System.out.println(Thread.currentThread().getName() +  ", invoke service3 method");
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
