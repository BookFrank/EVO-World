package com.tazine.evo.pattern;

import org.springframework.stereotype.Component;

/**
 * TestBean
 *
 * @author frank
 * @date 2019/08/14
 */
@Component
public class TestBean {

    public String test(String srvName) {
        System.out.println(srvName + ": Hello World");
        return "Hello World";
    }
}
