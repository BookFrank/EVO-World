package com.tazine.evo.boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author frank
 * @date 2018/11/07
 */
@RestController
public class TestController {

    @RequestMapping("/h/w")
    public String hi(){
        return "hello world";
    }

    @RequestMapping("/b/w")
    public String brave(){
        return "brave world";
    }
}
