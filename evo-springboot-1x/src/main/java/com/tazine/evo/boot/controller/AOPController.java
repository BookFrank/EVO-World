package com.tazine.evo.boot.controller;

import com.tazine.evo.boot.aop.CustomAop;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AOPController
 *
 * @author frank
 * @date 2019/05/15
 */
@RestController
public class AOPController {

    @CustomAop
    @RequestMapping("/aop")
    public String aop(String s){
        saySth("aop");
        return s;
    }

    public String saySth(String word){
        String s = word;
        System.out.println("say sth");
        return word;
    }
}
