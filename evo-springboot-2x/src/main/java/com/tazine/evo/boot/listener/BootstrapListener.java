package com.tazine.evo.boot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * ApplicationListener
 *
 * @author frank
 * @date 2018/10/31
 */
@Component
public class BootstrapListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // SpringMvc 中需要判断，防止启动两次，SpringBoot 不会传二次调用问题
        if (contextRefreshedEvent.getApplicationContext().getParent() != null) {
            System.err.println("Listener 统计到当前 Bean 个数为：" + contextRefreshedEvent.getApplicationContext().getBeanDefinitionCount());
        }
    }
}
