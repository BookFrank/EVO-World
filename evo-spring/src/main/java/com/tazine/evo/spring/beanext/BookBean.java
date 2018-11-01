package com.tazine.evo.spring.beanext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 实现了 InitializingBean 接口的 Bean 在实例化时会先调用 afterPropertiesSet 方法
 *
 * @author frank
 * @date 2018/10/31
 */
@Component
public class BookBean implements InitializingBean {

    public void afterPropertiesSet() throws Exception {
        System.err.println("BookBean 正在进行初始化");
    }

    @PostConstruct
    public void init(){
        System.err.println("BookBean PostConstruct 执行");
    }
}
