package com.tazine.evo.async.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 异步阻塞调用，
 *
 * @author jiaer.ly
 * @date 2018/03/21
 */
public class AsyncBlocking {

    /**
     * 异步阻塞方法调用，main 线程不用再去轮询拿到结果了，但是要被阻塞到方法执行完才能去干别的
     *
     * @return string
     */
    public String exec() throws ExecutionException, InterruptedException {
        Future<String> f = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "Hello From AsyncBlocking";
            }
        });
        return f.get();
    }
}
