package com.tazine.evo.async.spring;

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
public class AsyncService {

    public void syncRun(int i){
        System.out.println(Thread.currentThread().getName() + " -- " + i);
    }

    @Async("task-pool-1")
    public void asyncRun(int i){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " -- " + i + " 号任务执行完毕");
    }
}
