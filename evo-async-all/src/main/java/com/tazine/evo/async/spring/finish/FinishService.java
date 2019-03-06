package com.tazine.evo.async.spring.finish;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * FinishService
 *
 * @author frank
 * @date 2019/3/5
 */
@Slf4j
@Service
public class FinishService {

    @Async
    public ListenableFuture<Integer> asyncProcess() {
        log.info("执行中");
        int sec = new Random().nextInt(3);
        System.out.println(sec + " s");
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(sec);
    }

    @Async
    public ListenableFuture<Integer> latchProcess(CountDownLatch latch) {
        log.info("执行中");
        int sec = new Random().nextInt(5);
        System.out.println(sec + " s");
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
        log.info("进行countDown，剩余 {} 个", latch.getCount());
        return new AsyncResult<>(sec);
    }

}
