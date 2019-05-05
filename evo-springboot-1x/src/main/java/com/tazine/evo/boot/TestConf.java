package com.tazine.evo.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lina on 2019-05-05.
 *
 * @author frank
 * @date 2019-05-05
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
