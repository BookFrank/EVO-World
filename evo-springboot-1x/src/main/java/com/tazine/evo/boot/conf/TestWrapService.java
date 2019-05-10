package com.tazine.evo.boot.conf;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * TestWrapService
 *
 * @author frank
 * @date 2019/05/05
 */
public class TestWrapService {

    private TestService testService;

    @Autowired
    public TestWrapService(TestService testService) {
        this.testService = testService;
    }

    public void hi() {
        testService.sayHello();
    }
}
