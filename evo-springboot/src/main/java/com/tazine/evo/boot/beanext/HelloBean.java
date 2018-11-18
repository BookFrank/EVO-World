package com.tazine.evo.boot.beanext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * HelloBean
 *
 * @author frank
 * @date 2018/10/31
 */
@Component
public class HelloBean implements InitializingBean {

    @Autowired
    private ApplicationContext context;

    public void afterPropertiesSet() throws Exception {
        System.err.println("InitializingBean 统计到当前 Bean 个数为：" + context.getBeanDefinitionCount());
    }
}
