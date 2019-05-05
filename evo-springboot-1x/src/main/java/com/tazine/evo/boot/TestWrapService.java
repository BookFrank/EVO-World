package com.tazine.evo.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lina on 2019-05-05.
 *
 * @author frank
 * @date 2019-05-05
 */
public class TestWrapService {

    private TestService testService;

    @Autowired
    public TestWrapService(TestService testService) {
        this.testService = testService;
    }

    public void hi(){
        testService.sayHello();
    }
}
