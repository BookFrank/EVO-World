package com.tazine.evo.annotation.service.lifecycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 基于注解的 Bean Lifecycle
 *
 * @author frank
 * @date 2018/09/19
 */
@Component
public class AnnoBeanCycle {

    public AnnoBeanCycle() {
        System.out.println("AnnoBeanCycle Construct");
    }

    @PostConstruct
    public void init() {
        System.out.println("AnnoBeanCycle Init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("AnnoBeanCycle Destory");
    }

}
