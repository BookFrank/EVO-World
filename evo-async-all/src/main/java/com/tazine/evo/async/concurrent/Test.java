package com.tazine.evo.async.concurrent;

/**
 * Test
 *
 * @author jiaer.ly
 * @date 2018/03/20
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        //syncBlocking();


    }

    /**
     * 同步非阻塞，main 线程发起一个同步非阻塞方法调用后，可以
     */
    private static void syncNonBlocking(){
        SyncNonBlocking syncNonBlocking = new SyncNonBlocking();
        syncNonBlocking.exec();
        System.out.println(Thread.currentThread().getName() + "线程执行下一个业务逻辑");
    }

    /**
     * main 线程发起了一个对同步阻塞方法的调用，同步阻塞方法没执行完的时候，main 线程啥都不能干
     */
    private static void syncBlocking() throws InterruptedException {
        SyncBlocking syncBlocking = new SyncBlocking();
        syncBlocking.exec();
        System.out.println(Thread.currentThread().getName() + " 终于执行完同步阻塞方法了。");
    }

}
