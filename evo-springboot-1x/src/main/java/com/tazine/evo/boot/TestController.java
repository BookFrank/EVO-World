package com.tazine.evo.boot;

import com.alibaba.fastjson.JSON;
import com.tazine.evo.boot.aware.LoaderAware;
import com.tazine.evo.boot.conf.TestWrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;

/**
 * TestController
 *
 * @author frank
 * @date 2018/11/28
 */
@RestController
public class TestController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private LoaderAware loaderAware;

    @Autowired
    private TestWrapService testWrapService;

    @RequestMapping("/ds")
    public String test() throws SQLException {
        // SpringBoot1.x 的默认的数据源是 org.apache.tomcat.jdbc.pool.DataSource
        System.out.println(dataSource.getClass().getName());
//        System.out.println(dataSource.getConnection().prepareStatement("SELECT * FROM customer").executeQuery().getString("name"));
        return JSON.toJSONString(dataSource.getClass().getTypeName());
    }

    @RequestMapping("/cl")
    public String getCl() {
        return loaderAware.getClassLoader().getClass().getName();
    }

    @RequestMapping("/hi")
    public String hi(ServletRequest request) throws IOException {
        // 当为 form-data 时，req.getReader()会报错；inputStream不为空；
        // 当为 x-www-form-urlencoded 是正常；InputStream 是空；
        //System.out.println(null == request.getInputStream());
        System.out.println(JSON.toJSONString(request.getParameterMap()));
        //BufferedReader reader = request.getReader();
        byte[] body = readBytes(request.getReader(), "utf-8");
        return new String(body == null ? "null".getBytes() : body);
    }

    @RequestMapping("/say")
    public String say() {
        testWrapService.hi();
        return "say";
    }

    private byte[] readBytes(BufferedReader br, String encoding) throws IOException {
        String str = null, retStr = "";
        while ((str = br.readLine()) != null) {
            retStr += str;
        }
        if (!StringUtils.isEmpty(retStr)) {
            return retStr.getBytes(Charset.forName(encoding));
        }
        return null;
    }
}
