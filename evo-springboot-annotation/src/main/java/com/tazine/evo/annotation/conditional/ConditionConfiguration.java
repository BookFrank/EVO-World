package com.tazine.evo.annotation.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * ConditionConfiguration
 *
 * @author frank
 * @date 2018/09/26
 */
@Configuration
@ComponentScan(basePackages = "com.tazine.evo.annotation.conditional")
public class ConditionConfiguration {

    @Bean
    @Conditional(WindowsCondition.class)
    public ListFileService windowsListService() {
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public ListFileService linuxListService() {
        return new LinuxListService();
    }

    @Bean
    @Conditional(MacCondition.class)
    public ListFileService macListService() {
        return new LinuxListService();
    }

}
