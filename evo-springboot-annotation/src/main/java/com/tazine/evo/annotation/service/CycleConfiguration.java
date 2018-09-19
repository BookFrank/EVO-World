package com.tazine.evo.annotation.service;

import com.tazine.evo.annotation.service.lifecycle.BeanCycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * CycleConfiguration
 *
 * @author frank
 * @date 2018/09/19
 */
@Configuration
public class CycleConfiguration {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BeanCycle testCycle() {
        return new BeanCycle();
    }
}
