package com.tazine.evo.boot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * ServletContextListener servlet 容器监听器
 *
 * @author frank
 * @date 2018/11/01
 */
@WebListener
public class ServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.err.println("ServletListener init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 当程序终止时执行
        System.err.println("ServletListener destory");
    }
}
