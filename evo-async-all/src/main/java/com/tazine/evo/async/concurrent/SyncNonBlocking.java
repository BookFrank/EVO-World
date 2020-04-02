package com.tazine.evo.async.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 同步非阻塞调用，最常见的就是轮询
 *
 * @author jiaer.ly
 * @date 2018/03/20
 */
public class SyncNonBlocking {

    /**
     * 同步非阻塞调用，main 线程不会被阻塞可以去执行其他任务，但是需要不断轮询去拿到方法执行结果
     *
     * @return string
     */
    public Future<String> exec() {
        System.out.println(Thread.currentThread().getName() + "线程，进入 exec 方法体");
        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName() + "线程执行自己业务逻辑同时，main 线程非阻塞执行自己的逻辑");
                Thread.sleep(5000);
                return "Hello From SyncNonBlocking";
            }
        });
        new Thread(task).start();
        return task;
    }
}
