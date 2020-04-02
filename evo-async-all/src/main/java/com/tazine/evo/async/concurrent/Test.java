package com.tazine.evo.async.concurrent;

import java.util.concurrent.Future;

/**
 * Test
 *
 * @author jiaer.ly
 * @date 2018/03/20
 */
public class Test {

    public static void main(String[] args) throws Exception {
        //syncBlocking();

        //syncNonBlocking();

        asyncNonBlocking();
    }

    private static void asyncNonBlocking() throws InterruptedException {
        AsyncNonBlocking asyncNonBlocking = new AsyncNonBlocking();
        asyncNonBlocking.exec();
        while (true) {
            System.out.println(Thread.currentThread().getName() + "线程,执行下一个业务逻辑");
            Thread.sleep(1000);
        }
    }

    /**
     * 同步非阻塞，main 线程发起一个同步非阻塞方法调用后，可以
     */
    private static void syncNonBlocking() throws Exception {
        SyncNonBlocking syncNonBlocking = new SyncNonBlocking();
        Future<String> future = syncNonBlocking.exec();
        // 在轮询的过程中 main 线程始终处于 RUNNING 状态，并没有被阻塞，但是是因为消息通知方式是同步的，所以需要main线程不断的轮询
        // 使用 Future 确实可以获取异步任务的执行结果，但是获取其结果还是会阻塞调用线程，并没有实现完全异步化
        while (true) {
            if (future.isDone()) {
                String ret = future.get();
                System.out.println(Thread.currentThread().getName() + "线程，拿到此前非阻塞调用的结果：" + ret);
                break;
            } else {
                System.out.println(Thread.currentThread().getName() + "线程,执行下一个业务逻辑");
                Thread.sleep(1000);
            }
        }
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
