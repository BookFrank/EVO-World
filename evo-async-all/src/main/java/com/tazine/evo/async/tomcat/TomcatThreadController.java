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
public class TomcatThreadController {

    @Autowired
    private AppService appService;

    @RequestMapping("/test")
    public String hi() {
        log.info("enter controller");
        //appService.syncSleep();
        return "Hello World";
    }
}
