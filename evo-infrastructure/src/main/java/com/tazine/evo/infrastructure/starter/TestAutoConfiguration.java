package com.tazine.evo.infrastructure.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类：实现自动配置功能的一个入口
 *
 * @author frank
 * @date 2019/05/28
 */
@Configuration
@ConditionalOnProperty(prefix = "test", name = "name")
@EnableConfigurationProperties({TestProperties.class})
public class TestAutoConfiguration {

    private final TestProperties testProperties;

    public TestAutoConfiguration(TestProperties testProperties) {this.testProperties = testProperties;}

    @Bean
    public TestService testBean() {
        return new TestService(testProperties);
    }
}
