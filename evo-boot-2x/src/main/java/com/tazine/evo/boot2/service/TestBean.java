package com.tazine.evo.boot2.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author jiaer.ly
 * @date 2019/10/31
 */
@Component
@Scope(value = "prototype")
public class TestBean {

    private String s = UUID.randomUUID().toString();

    public void say(){
        System.out.println(s);
    }
}
