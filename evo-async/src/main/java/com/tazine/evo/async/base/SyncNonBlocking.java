package com.tazine.evo.async.base;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 同步非阻塞-轮询
 *
 * @author jiaer.ly
 * @date 2020/04/03
 */
public class SyncNonBlocking {

    public Future<String> exec(){
        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000 * 3);
                return "halo form SyncNonBlocking";
            }
        });
        new Thread(task).start();
        return task;
    }
}
