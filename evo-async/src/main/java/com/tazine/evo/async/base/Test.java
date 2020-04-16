package com.tazine.evo.async.base;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Test
 *
 * @author jiaer.ly
 * @date 2020/04/02
 */
public class Test {

    public static void main(String[] args) throws Exception {
        // syncBlocking();

        // syncNonBlocking();

        asyncBlocking();

        // asyncNonBlocking();
    }

    /**
     * 在拿到 exec() 方法前，main 线程是阻塞的
     *
     * @throws ExecutionException   e1
     * @throws InterruptedException e2
     */
    private static void asyncBlocking() throws ExecutionException, InterruptedException {
        AsyncBlocking asyncBlocking = new AsyncBlocking();

        Future<String> future = asyncBlocking.exec();

        System.out.println(future.get());

    }

    private static void asyncNonBlocking() throws InterruptedException {
        AsyncNonBlocking asyncNonBlocking = new AsyncNonBlocking();
        asyncNonBlocking.exec();

        Thread.sleep(1000 * 5);
        System.out.println("hi");
    }

    public static void callback(String ret) {
        System.out.println(ret);
    }

    /**
     * 在拿到 exec() 结果的过程中，main 线程是非阻塞的
     *
     * @throws Exception e
     */
    private static void syncNonBlocking() throws Exception {
        SyncNonBlocking syncNonBlocking = new SyncNonBlocking();
        Future<String> future = syncNonBlocking.exec();
        while (true) {
            if (future.isDone()) {
                System.out.println(future.get());
                break;
            } else {
                System.out.println("wait");
                Thread.sleep(1000 * 1);
            }
        }
    }

    private static void syncBlocking() {
        SyncBlocking syncBlocking = new SyncBlocking();
        String ret = syncBlocking.exec();
        System.out.println(ret);
    }
}
