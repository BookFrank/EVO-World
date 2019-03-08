package com.tazine.evo.async.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 *
 * @author frank
 * @date 2018/09/16
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/sync")
    public String syncTest() {
        for (int i = 1; i < 101; i++) {
            asyncService.syncRun(i);
        }
        return "Hello Sync";
    }

    @RequestMapping("/async")
    public String asyncTest() {
        for (int i = 1; i < 101; i++) {
            System.out.println(Thread.currentThread().getName() + " 开始执行任务：" + i);
            asyncService.asyncRun(i);
        }
        return "Hello Async";
    }

    @RequestMapping("/future")
    public String asyncFuture() throws Exception {
        log.info("进入 /future 接口内部");
        return asyncService.sayHello("frank").get();
    }
}
