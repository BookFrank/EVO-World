package com.tazine.evo.annotation.conditional;

import com.tazine.evo.annotation.conditional.boot.*;
import com.tazine.evo.annotation.conditional.raw.RedisService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
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

    @Bean
    @ComputerDomain(domain = "local")
    @ConditionalOnClass(ComputerDomainCondition.class)
    public DomainService localRedis(){
        System.out.println("localRedis");
        return new LocalDomainService();
    }

    @Bean
    @ComputerDomain(domain = "hongkong")
    @ConditionalOnClass(ComputerDomainCondition.class)
    public DomainService hkRedis(){
        System.out.println("hkRedis");
        return new HongKongDomainService();
    }
}
