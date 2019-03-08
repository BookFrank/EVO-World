package com.tazine.evo.boot.ioc;

import com.tazine.evo.boot.ioc.without.ServiceTwo;

/**
 * IOCTest
 *
 * @author frank
 * @date 2019/03/08
 */
public class IOCTest {

    public static void main(String[] args) {

        // 1. 自定义 ServiceFactory
        ServiceTwo serviceTwo = new ServiceTwo();
        serviceTwo.process();

        // 2. 使用 Spring IoC 容器
    }

}
