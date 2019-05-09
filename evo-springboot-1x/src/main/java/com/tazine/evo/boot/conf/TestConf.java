package com.tazine.evo.boot.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Nested Bean Conf
 *
 * @author frank
 * @date 2019/05/05
 */
@Configuration
public class TestConf {

    @Bean
    public TestService testService(){
        return new TestService();
    }

    @Bean
    public TestWrapService testWrapService(TestService testService){
        return new TestWrapService(testService);
    }
}
