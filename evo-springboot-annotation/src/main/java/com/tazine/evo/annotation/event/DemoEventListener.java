package com.tazine.evo.annotation.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * DemoEventListener，实现 ApplicationListener 接口并指定监听的事件类型
 *
 * @author frank
 * @date 2018/09/25
 */
@Component
public class DemoEventListener implements ApplicationListener<DemoEvent> {

    /**
     * 通过 onApplicationEvent 方法对信息进行接受处理
     *
     * @param demoEvent DemoEvent
     */
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();
        System.err.println("Bean-DemoEventListener 接收到了 Bean-DemoEventPublisher 发布的信息：" + msg);
    }
}
