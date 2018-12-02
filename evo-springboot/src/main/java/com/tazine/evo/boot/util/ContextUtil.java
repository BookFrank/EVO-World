package com.tazine.evo.boot.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * ContextUtil
 *
 * @author frank
 * @since 1.0.0
 */
public class ContextUtil implements ApplicationContextAware{

    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getContext(){
        return context;
    }

    public static Object getBean(String name){
        return getContext().getBean(name);
    }

    //通过class获取Bean.

    public static <T> T getBean(Class<T> clazz){
        return getContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){
        return getContext().getBean(name, clazz);
    }
}
