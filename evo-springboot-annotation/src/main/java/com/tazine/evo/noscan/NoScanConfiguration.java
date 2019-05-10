package com.tazine.evo.noscan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * NoScanConfiguration
 *
 * @author frank
 * @date 2018/09/26
 */
@Configuration
public class NoScanConfiguration {

    @Bean
    public DemoService demoService() {
        return new DemoService();
    }
}
