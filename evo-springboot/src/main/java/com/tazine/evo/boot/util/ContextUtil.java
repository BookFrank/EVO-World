package com.tazine.evo.boot.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ContextUtil
 *
 * @author frank
 * @date 2018/11/11
 */
@Component
public class ContextUtil implements ApplicationContextAware {

    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static Object getBean(String name) {
        return getContext().getBean(name);
    }

    /**
     * 通过class获取Bean.
     *
     * @param clazz clz
     * @param <T>   T
     * @return T
     */
    public static <T> T getBean(Class<T> clazz) {
        return getContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name, Class<T> clazz) {
        return getContext().getBean(name, clazz);
    }

    public static void getBeanNamesForAnnotation(Class clz) {
        String[] beanNames = getContext().getBeanNamesForAnnotation(clz);
        System.out.println("Service注解beanNames个数：" + beanNames.length);
        for (String bn : beanNames) {
            System.out.println(bn);
        }
    }
}
