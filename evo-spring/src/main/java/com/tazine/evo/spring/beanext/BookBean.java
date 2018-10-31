package com.tazine.evo.spring.beanext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author frank
 * @date 2018/10/31
 */
@Component
public class BookBean implements InitializingBean{

    public void afterPropertiesSet() throws Exception {
        System.err.println("BookBean 正在进行初始化");
    }
}
