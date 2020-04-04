package com.tazine.evo.async.jvm;

import java.util.concurrent.Future;

/**
 * Test
 *
 * @author jiaer.ly
 * @date 2020/04/02
 */
public class Test {

    public static void main(String[] args) throws Exception {
        //syncNonBlocking();

        asyncNonBlocking();
    }

    private static void asyncNonBlocking() throws InterruptedException {
        AsyncNonBlocking asyncNonBlocking = new AsyncNonBlocking();
        asyncNonBlocking.exec();

        Thread.sleep(1000 * 5);
        System.out.println("hi");
    }

    public static void callback(String ret){
        System.out.println(ret);
    }

    private static void syncNonBlocking() throws Exception {
        SyncNonBlocking syncNonBlocking = new SyncNonBlocking();
        Future<String> future = syncNonBlocking.exec();
        while (true){
            if (future.isDone()){
                System.out.println(future.get());
                break;
            }else {
                System.out.println("wait");
                Thread.sleep(1000 * 1);
            }
        }
    }

    private static void syncBlocking(){
        SyncBlocking syncBlocking = new SyncBlocking();
        String ret = syncBlocking.exec();
        System.out.println(ret);
    }
}
