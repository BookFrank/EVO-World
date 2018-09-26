package com.tazine.evo.annotation.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * Demo 事件类，继承 ApplicationEvent
 *
 * @author frank
 * @date 2018/09/23
 */
@Data
public class DemoEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }
}
