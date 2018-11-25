package com.tazine.evo.unit;

import com.tazine.evo.unit.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot 基础测试
 *
 * @author frank
 * @date 2018/11/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BootBaseTest {

    @Autowired
    private HelloService helloService;

    @Test
    public void testHelloService(){
        helloService.sayHello();
    }
}
