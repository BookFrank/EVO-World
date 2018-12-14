package com.tazine.evo.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试线程池慢了以后什么操作
 *
 * @author frank
 * @date 2018/12/13
 */
@RestController
public class TestThreadController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public String hi(){
        testService.sleep();
        return "Hello World";
    }
}
