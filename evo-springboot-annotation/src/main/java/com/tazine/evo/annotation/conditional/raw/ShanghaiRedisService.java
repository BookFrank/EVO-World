package com.tazine.evo.annotation.conditional.raw;

/**
 * ShanghaiRedisService
 *
 * @author frank
 * @date 2019/05/01
 */
public class ShanghaiRedisService implements RedisService {

    @Override
    public void sayHi() {
        System.out.println("Hello From Shanghai");
    }
}
