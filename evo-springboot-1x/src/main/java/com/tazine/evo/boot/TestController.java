package com.tazine.evo.boot;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author frank
 * @date 2018/11/28
 */
@RestController
public class TestController {

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/test")
    public String test() throws SQLException {
        System.out.println(dataSource.getClass().getName());
//        System.out.println(dataSource.getConnection().prepareStatement("SELECT * FROM customer").executeQuery().getString("name"));
        return JSON.toJSONString(dataSource.getClass().getTypeName());
    }
}
