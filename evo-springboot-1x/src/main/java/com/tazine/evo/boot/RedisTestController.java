package com.tazine.evo.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    @RequestMapping("/get")
    public String get(){
        System.out.println("haha");
        String val = (String) redisTemplate.opsForValue().get("frank");
        return val;
    }
}
