package com.tazine.evo.annotation.conditional.raw;

/**
 * BeijingRedisService
 *
 * @author frank
 * @date 2019/05/01
 */
public class BeijingRedisService implements RedisService {

    @Override
    public void sayHi() {
        System.out.println("Hello From Beijing");
    }
}
