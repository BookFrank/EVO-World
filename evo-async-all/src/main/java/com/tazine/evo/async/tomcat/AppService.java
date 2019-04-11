package com.tazine.evo.async.tomcat;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * AppService
 *
 * @author frank
 * @date 2018/12/14
 */
@Service
public class AppService {

    /**
     * 让该线程一直沉睡
     */
    public void syncSleep() {
        System.out.println("ThreadName： " + Thread.currentThread().getName());
        try {
            TimeUnit.DAYS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Async
    //@Async("async-service")
    public void asyncSleep() {
        System.out.println("ThreadName： " + Thread.currentThread().getName());
        try {
            TimeUnit.DAYS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
