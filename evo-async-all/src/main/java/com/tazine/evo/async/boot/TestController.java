package com.tazine.evo.async.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author frank
 * @date 2018/09/16
 */
@RestController
public class TestController {

    @Autowired
    private AsyncInstance asyncInstance;

    @RequestMapping("/sync")
    public String syncTest() {
        for (int i = 1; i < 101; i++) {
            asyncInstance.syncRun(i);
            System.out.println(i + " 已开始执行");
        }
        return "Hello Sync";
    }

    @RequestMapping("/async")
    public String asyncTest() {
        for (int i = 1; i < 101; i++) {
            asyncInstance.asyncRun(i);
            System.out.println(i + " 已开始执行");
        }
        return "Hello Async";
    }
}
