package com.tazine.evo.async.tomcat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Tomcat线程池测试
 *
 * @author frank
 * @date 2018/12/13
 */
@Slf4j
@RestController
@RequestMapping("/tomcat")
public class TomcatThreadController {

    @Autowired
    private AppService appService;

    @RequestMapping("/async")
    public String async(){
        appService.asyncSleep();
        return "Hello Sync";
    }

    @RequestMapping("/sync")
    public String sync() {
        log.info("enter sync controller");
        appService.syncSleep();
        return "Hello World";
    }
}
