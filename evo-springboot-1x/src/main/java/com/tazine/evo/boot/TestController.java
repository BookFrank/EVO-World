package com.tazine.evo.boot;

import com.alibaba.fastjson.JSON;
import com.tazine.evo.boot.aware.LoaderAware;
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

    @Autowired
    private LoaderAware loaderAware;

    @RequestMapping("/ds")
    public String test() throws SQLException {
        // SpringBoot1.x 的默认的数据源是 org.apache.tomcat.jdbc.pool.DataSource
        System.out.println(dataSource.getClass().getName());
//        System.out.println(dataSource.getConnection().prepareStatement("SELECT * FROM customer").executeQuery().getString("name"));
        return JSON.toJSONString(dataSource.getClass().getTypeName());
    }

    @RequestMapping("/cl")
    public String getCl(){
        return loaderAware.getClassLoader().getClass().getName();
    }
}
