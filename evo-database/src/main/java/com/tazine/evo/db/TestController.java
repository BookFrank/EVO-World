package com.tazine.evo.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiaer.ly
 * @date 2020/04/07
 */
@RestController
@EnableConfigurationProperties(MultiMybatisProperties.class)
public class TestController {

    @Autowired
    private MultiMybatisProperties properties;

    @RequestMapping("/test")
    public MultiMybatisProperties test(){
        return properties;
    }
}
