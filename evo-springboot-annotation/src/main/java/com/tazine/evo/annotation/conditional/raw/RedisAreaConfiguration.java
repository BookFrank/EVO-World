package com.tazine.evo.annotation.conditional.raw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * RedisAreaConfiguration
 *
 * @author frank
 * @date 2019/05/01
 */
@Configuration
public class RedisAreaConfiguration {

    @Bean
    @Conditional(BeijingCondition.class)
    public RedisService beijingRedis(){
        return new BeijingRedisService();
    }

    @Bean
    @Conditional(ShanghaiCondition.class)
    public RedisService shanghaiRedis(){
        return new ShanghaiRedisService();
    }
}
