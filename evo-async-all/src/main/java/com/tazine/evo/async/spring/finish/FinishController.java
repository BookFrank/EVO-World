package com.tazine.evo.async.spring.finish;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * FinishController
 *
 * @author frank
 * @date 2019/3/5
 */
@Slf4j
@RestController
public class FinishController {

    @Autowired
    //@Qualifier("async-service")
    @Qualifier("task-pool-1")
    private ThreadPoolTaskExecutor executor;

    @RequestMapping("/f1")
    public String f1() throws ExecutionException, InterruptedException {
        List<Future<Integer>> futureList = Lists.newArrayList();
        for (int i = 0; i < 4; i++) {
            Future<Integer> future = executor.submit(() -> process());
            futureList.add(future);
        }
        log.info("任务提交完毕");
        List<Integer> list = Lists.newArrayList();
        int i =1;
        while (true){
            System.out.println("循环：" + i++);
            if (futureList.size() == 0){
                break;
            }
            for (int j = 0; j< futureList.size(); j++){
                Future f = futureList.get(j);
                if (f.isDone()){
                    list.add((Integer)f.get());
                    futureList.remove(f);
                }
            }
            Thread.sleep(1000);
        }
        return list.toString();
    }

    @RequestMapping("/f2")
    public String f2() throws Exception{
        List<Future<Integer>> futureList = Lists.newArrayList();
        for (int i = 0; i < 4; i++) {
            futureList.add(asyncProcess());
        }
        log.info("任务提交完毕");
        List<Integer> list = Lists.newArrayList();
        int i =1;
        while (true){
            System.out.println("循环：" + i++);
            if (futureList.size() == 0){
                break;
            }
            for (int j = 0; j< futureList.size(); j++){
                Future f = futureList.get(j);
                if (f.isDone()){
                    list.add((Integer)f.get());
                    futureList.remove(f);
                }
            }
            Thread.sleep(1000);
        }
        return list.toString();
    }

    private int process() {
        log.info("执行中");
        int sec = new Random().nextInt(3);
        System.out.println(sec + " s");
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sec;
    }

    private ListenableFuture<Integer> asyncProcess() {
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
}
