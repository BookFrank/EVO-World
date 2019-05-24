package com.tazine.evo.boot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * 基于Redis的分布式锁
 *
 * @author frank
 * @date 2019/05/24
 */
@Component
public class RedLock {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostConstruct
    public void init(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
    }

    public boolean lock(String lockKey, String lockVal){
        //redisTemplate.opsForValue().setIfAbsent();
        boolean getLock = redisTemplate.opsForValue().setIfAbsent(lockKey, lockVal);
        if (getLock){
            redisTemplate.expire(lockKey, 120, TimeUnit.SECONDS);
            System.out.println(lockVal + " 获得锁");
        }
        return getLock;
    }

    public boolean unlock(String lockKey, String lockVal){
        String currentVal = redisTemplate.opsForValue().get(lockKey).toString();
        if (lockVal.equalsIgnoreCase(currentVal)){
            redisTemplate.delete(lockKey);
            System.out.println(lockVal + " 释放锁");
            return true;
        }
        return false;
    }
}
