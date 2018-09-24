package com.tazine.evo.annotation.event;

import org.springframework.context.ApplicationEvent;

/**
 * Demo 事件
 *
 * @author frank
 * @date 2018/09/23
 */
public class DemoEvent extends ApplicationEvent {

    public DemoEvent(Object source) {
        super(source);
    }
}
