package com.tazine.evo.infrastructure.conf;

import com.tazine.evo.infrastructure.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author frank
 * @date 2019/05/28
 */
@Configuration
public class TestConf {

    @Bean
    public TestBean testBean(){
        return new TestBean();
    }
}
