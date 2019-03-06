package com.tazine.evo.async.tomcat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Tomcat线程池测试
 *
 * @author frank
 * @date 2018/12/13
 */
@RestController
public class TomcatThreadController {

    @Autowired
    private AppService appService;

    @RequestMapping("/test")
    public String hi() {
        appService.syncSleep();
        return "Hello World";
    }
}
