package com.tazine.evo.async.spring.finish;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * FinishService
 *
 * @author frank
 * @date 2019/3/5
 */
@Service
public class FinishService {

    public int process(){
        int sec = new Random().nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sec;
    }

}
