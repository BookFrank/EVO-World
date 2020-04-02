package com.tazine.evo.concurrent.sync.synchronize;

/**
 * @author jiaer.ly
 * @date 2020/03/30
 */
public class Test {

    public static void main(String[] args) {

        //synchronizedIsObjectLock();

        //synchronizedCanReentry();

        syncBlockIsBetterThanMethod();
    }

    /**
     * 使用 synchronized 同步代码块缩短了加锁时间，但是因为本身还是同步，程序的执行效率并没有提高？
     */
    private static void syncBlockIsBetterThanMethod() {
        SyncDemo syncDemo = new SyncDemo();

        new Thread(() -> {
            syncDemo.syncMethodD();
        }).start();

        new Thread(() -> {
            syncDemo.syncMethodC();
        }).start();
    }

    /**
     * synchronized 是一个可重入的锁
     */
    private static void synchronizedCanReentry(){
        ReEntryDemo entryDemo = new ReEntryDemo();

        new Thread(() -> {
            entryDemo.service3();
        }).start();

        new Thread(() -> {
            entryDemo.service1();
        }).start();
    }

    /**
     * 说明加在方法上的 synchronized 实际上是一个对象锁
     */
    private static void synchronizedIsObjectLock(){
        SyncDemo syncDemo = new SyncDemo();

        // syncMethodA 未执行完之前，methodB 是可以并发执行的，但是 syncMethodC 无法执行。
        new Thread(() -> {
            syncDemo.syncMethodA();
        }).start();

        new Thread(() -> {
            syncDemo.methodB();
        }).start();

        new Thread(() -> {
            syncDemo.syncMethodC();
        }).start();
    }
}
