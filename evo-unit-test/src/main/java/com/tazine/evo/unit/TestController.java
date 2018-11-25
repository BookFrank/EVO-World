package com.tazine.evo.unit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author frank
 * @date 2018/11/25
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        System.out.println(Thread.currentThread().getName());
        return Thread.currentThread().getName();
    }

    @RequestMapping("/test1")
    public String test1(){
        System.out.println(Thread.currentThread().getName());
        return Thread.currentThread().getName();
    }

}
