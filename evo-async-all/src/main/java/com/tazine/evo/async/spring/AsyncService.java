package com.tazine.evo.async.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.TimeUnit;

/**
 * 异步实例类
 *
 * @author frank
 * @date 2018/09/16
 */
@Slf4j
@Service
public class AsyncService {

    public void syncRun(int i) {
        System.out.println(Thread.currentThread().getName() + " -- " + i);
    }

    @Async("task-pool-1")
    public void asyncRun(int i) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " -- " + i + " 号任务执行完毕");
    }

    /**
     * 带返回值的异步执行
     *
     * @param name name
     * @return s
     * @throws InterruptedException e
     */
    @Async
    public ListenableFuture<String> sayHello(String name) throws InterruptedException {
        String res = name + " : Hello World";
        log.info("sayHello 处理中...");
        Thread.sleep(2000);
        return new AsyncResult<>(res);
    }
}