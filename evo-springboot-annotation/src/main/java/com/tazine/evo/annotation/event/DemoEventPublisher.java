package com.tazine.evo.annotation.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 事件发布类
 *
 * @author frank
 * @date 2018/09/25
 */
@Component
public class DemoEventPublisher {

    /**
     * 注入 ApplicationContext 用来发布事件
     */
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 使用 ApplicationContext 的 publishEvent 方法来发布
     *
     * @param msg message
     */
    public void publish(String msg) {
        applicationContext.publishEvent(new DemoEvent(this, msg));
    }

}
