package com.tazine.evo.boot.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * ContextAwareService，实现ApplicationContextAware 可以获得Spring容器的所有服务
 *
 * @author frank
 * @date 2018/09/26
 */
@Service
public class ContextAwareService implements ApplicationContextAware {

    //@Autowired
    //private ApplicationContext context;

    private ApplicationContext context;

//    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void output() {
        String appName = context.getApplicationName();
        int count = context.getBeanDefinitionCount();
        System.out.println("应用名称为：" + appName + "，总共有 " + count + " bean");
    }
}
