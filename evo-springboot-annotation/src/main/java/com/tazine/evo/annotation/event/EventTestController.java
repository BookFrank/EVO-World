package com.tazine.evo.annotation.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 Spring 事件
 *
 * @author frank
 * @date 2018/10/31
 */
@RestController
public class EventTestController {

    @Autowired
    private DemoEventPublisher eventPublisher;

    @RequestMapping("/event/test")
    public String eventTest() {
        eventPublisher.publish("event 测试");
        return "Spring Event";
    }
}
