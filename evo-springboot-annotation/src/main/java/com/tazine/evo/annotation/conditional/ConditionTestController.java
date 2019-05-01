package com.tazine.evo.annotation.conditional;

import com.tazine.evo.annotation.conditional.raw.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConditionTestController
 *
 * @author frank
 * @date 2019/05/01
 */
@RestController
public class ConditionTestController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/redis")
    public String testRedis(){
        redisService.sayHi();
        return "OK";
    }
}
