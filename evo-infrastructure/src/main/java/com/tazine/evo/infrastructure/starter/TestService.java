package com.tazine.evo.infrastructure.starter;

/**
 * Service 中使用 TestProperties 的属性
 *
 * @author frank
 * @date 2019/05/28
 */
public class TestService {

    private TestProperties testProperties;

    public TestService(TestProperties testProperties) {
        this.testProperties = testProperties;
    }

    public String hi() {
        return testProperties.getName();
    }
}
