package com.tazine.evo.boot.util.redlock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

/**
 * GETSET 实现分布式锁
 *
 * @author frank
 * @date 2019/05/26
 */
@Slf4j
public class ProdRedLock {

    private static final int TIMEOUT = 120 * 1000;

    @Autowired
    private RedisTemplate redisTemplate;

    public boolean lock(String lockKey, String lockVal) {
        if (redisTemplate.opsForValue().setIfAbsent(lockKey, lockVal)) {
            return true;
        }
        //currentValue=A   这两个线程的value都是B  其中一个线程拿到锁
        String currentValue = (String)redisTemplate.opsForValue().get(lockKey);
        //如果锁过期
        if (!StringUtils.isEmpty(currentValue)
            && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            //获取上一个锁的时间
            String oldValue = (String)redisTemplate.opsForValue().getAndSet(lockKey, lockVal);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }
        }

        return false;
    }

    public void unlock(String lockKey, String lockVal){
        try {
            String currentValue = (String)redisTemplate.opsForValue().get(lockKey);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(lockVal)) {
                redisTemplate.opsForValue().getOperations().delete(lockKey);
            }
        }catch (Exception e) {
            log.error("【redis分布式锁】解锁异常, {}", e);
        }
    }
}
