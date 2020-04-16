package com.tazine.evo.async.base;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 异步阻塞
 *
 * @author jiaer.ly
 * @date 2020/03/01
 */
public class AsyncBlocking {

    public Future<String> exec(){
        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000 * 3);
                return "halo form AsyncBlocking";
            }
        });
        new Thread(task).start();
        return task;
    }
}
