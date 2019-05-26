package com.tazine.evo.boot.util.redlock;

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
public class SimpRedLock {

    private final RedisTemplate redisTemplate;

    public SimpRedLock(RedisTemplate redisTemplate) {this.redisTemplate = redisTemplate;}

    @PostConstruct
    public void init() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
    }

    /**
     * 加锁
     *
     * @param lockKey key
     * @param lockVal val
     * @return boolean
     */
    public boolean lock(String lockKey, String lockVal) {
        //redisTemplate.opsForValue().setIfAbsent();
        boolean getLock = redisTemplate.opsForValue().setIfAbsent(lockKey, lockVal);
        if (getLock) {
            redisTemplate.expire(lockKey, 120, TimeUnit.SECONDS);
            System.out.println(lockVal + " 获得锁");
        }
        return getLock;
    }

    /**
     * 解锁
     *
     * @param lockKey key
     * @param lockVal val
     * @return boolean
     */
    public boolean unlock(String lockKey, String lockVal) {
        String currentVal = redisTemplate.opsForValue().get(lockKey).toString();
        if (lockVal.equalsIgnoreCase(currentVal)) {
            redisTemplate.delete(lockKey);
            System.out.println(lockVal + " 释放锁");
            return true;
        }
        return false;
    }
}
