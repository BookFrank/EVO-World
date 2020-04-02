package com.tazine.evo.concurrent.webflux;

import org.springframework.stereotype.Service;

/**
 * @author jiaer.ly
 * @date 2020/03/26
 */
@Service
public class FluxService {

    public String hi(){

        System.out.println("Service Thread: " + Thread.currentThread().getName());

        return "hello world";
    }
}
