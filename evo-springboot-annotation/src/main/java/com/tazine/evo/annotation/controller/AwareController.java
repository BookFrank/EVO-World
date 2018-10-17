package com.tazine.evo.annotation.controller;

import com.alibaba.fastjson.JSON;
import com.tazine.evo.annotation.aware.ContextAwareService;
import com.tazine.evo.annotation.aware.ResourceAwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring 中的 Aware 感知
 *
 * @author frank
 * @date 2018/10/17
 */
@RestController
public class AwareController {

    @Autowired
    private ResourceAwareService resourceAwareService;

    @Autowired
    private ContextAwareService contextAwareService;

    @Autowired
    private ApplicationContext context;

    @RequestMapping("/res/aware")
    public void resourceAware() {
        resourceAwareService.outputResult();
    }

    @RequestMapping("/ctx/aware")
    public void contextAware() {
        contextAwareService.output();
    }

    @RequestMapping("/ctx")
    public String ctx() {
        System.out.println(JSON.toJSONString(context.getEnvironment()));
        String name = context.getEnvironment().getProperty("spring.application.name");
        return name;
    }
}
