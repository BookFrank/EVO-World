package com.tazine.evo.async.boot;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 异步实例类
 *
 * @author frank
 * @date 2018/09/16
 */
@Service
public class AsyncInstance {

    public void syncRun(int i){
        System.out.println(Thread.currentThread().getName() + " -- " + i);
    }

    @Async
    public void asyncRun(int i){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " -- " + i);
    }
}
