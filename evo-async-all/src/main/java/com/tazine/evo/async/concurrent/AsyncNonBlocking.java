package com.tazine.evo.async.concurrent;

import java.util.concurrent.CompletableFuture;

/**
 * 异步非阻塞
 *
 * @author jiaer.ly
 * @date 2018/03/20
 */
public class AsyncNonBlocking {

    public void exec() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "线程执行自己业务逻辑同时，main 线程非阻塞执行自己的逻辑");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello From SyncNonBlocking";
        });

        future.whenComplete((s, throwable) -> System.out.println(Thread.currentThread().getName() + "线程, " + s));
    }
}
