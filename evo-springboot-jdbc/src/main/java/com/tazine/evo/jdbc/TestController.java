package com.tazine.evo.jdbc;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * @author jiaer.ly
 * @date 2018/11/28
 */
@RestController
public class TestController {

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/test")
    public String test(){
        System.out.println(dataSource.getClass().getName());
        return JSON.toJSONString(dataSource);
    }

}