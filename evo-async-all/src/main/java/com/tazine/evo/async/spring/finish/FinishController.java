package com.tazine.evo.async.spring.finish;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

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
    private FinishService finishService;

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
        int i = 1;
        while (true) {
            System.out.println("循环：" + i++);
            if (futureList.size() == 0) {
                break;
            }
            for (int j = 0; j < futureList.size(); j++) {
                Future f = futureList.get(j);
                if (f.isDone()) {
                    list.add((Integer)f.get());
                    futureList.remove(f);
                }
            }
            Thread.sleep(1000);
        }
        return list.toString();
    }

    @RequestMapping("/f2")
    public String f2() throws Exception {
        List<Future<Integer>> futureList = Lists.newArrayList();
        for (int i = 0; i < 4; i++) {
            futureList.add(finishService.asyncProcess());
        }
        log.info("任务提交完毕");
        List<Integer> list = Lists.newArrayList();
        int i = 1;
        while (true) {
            System.out.println("循环：" + i++);
            if (futureList.size() == 0) {
                break;
            }
            for (int j = 0; j < futureList.size(); j++) {
                Future f = futureList.get(j);
                if (f.isDone()) {
                    list.add((Integer)f.get());
                    futureList.remove(f);
                }
            }
            Thread.sleep(1000);
        }
        return list.toString();
    }

    @RequestMapping("/f3")
    public String f3() throws Exception {
        CountDownLatch latch = new CountDownLatch(4);
        List<Future<Integer>> futureList = Lists.newArrayList();
        for (int i = 0; i < 4; i++) {
            futureList.add(executor.submit(() -> latchProcess(latch)));
        }
        log.info("任务提交完毕");
        latch.await();
        log.info("任务全部执行完毕");
        List<Integer> list = Lists.newArrayList();
        for (int j = 0; j < futureList.size(); j++) {
            Future f = futureList.get(j);
            if (f.isDone()) {
                list.add((Integer)f.get());
            }else{
                log.error("还没执行完毕");
            }
        }
        return list.toString();
    }

    @RequestMapping("/f4")
    public String f4() throws Exception {
        CountDownLatch latch = new CountDownLatch(4);
        List<Future<Integer>> futureList = Lists.newArrayList();
        for (int i = 0; i < 4; i++) {
            futureList.add(finishService.latchProcess(latch));
        }
        log.info("任务提交完毕");
        latch.await();
        log.info("任务全部执行完毕");
        List<Integer> list = Lists.newArrayList();
        for (int j = 0; j < futureList.size(); j++) {
            Future f = futureList.get(j);
            if (f.isDone()) {
                list.add((Integer)f.get());
            }else{
                log.error("还没执行完毕");
            }
        }
        return list.toString();
    }

    private int process() {
        log.info("执行中");
        int sec = new Random().nextInt(5);
        System.out.println(sec + " s");
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sec;
    }

    private int latchProcess(CountDownLatch latch) {
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
        return sec;
    }
}
