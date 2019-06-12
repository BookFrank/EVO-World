package com.tazine.evo.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by frank on 2019-05-24.
 *
 * @author frank
 * @date 2019/05/24
 */
@RestController
public class RedisTestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/setnx")
    public boolean setnx(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate.opsForValue().setIfAbsent("jiaer", "yc");
    }

    @RequestMapping("/get")
    public String get(){
        System.out.println("haha");
        // RedisTemplate 的 key 和 Value 默认是 JDK 序列化的，在命令行中可能找不到
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().set("jiaer", "yc");
        String val = (String) redisTemplate.opsForValue().get("jiaer");
        return val;
    }
}
