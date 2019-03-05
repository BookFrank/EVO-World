package com.tazine.evo.async.tomcat;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author frank
 * @date 2018/12/14
 */
@Service
public class TestService {


//    @Async("async-service")
    public void sleep(){
        System.out.println("ThreadName： " + Thread.currentThread().getName());
        try {
            TimeUnit.DAYS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
