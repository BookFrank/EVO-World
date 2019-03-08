package com.tazine.evo.boot.ioc.without;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Service工厂类似于Bean工厂
 *
 * @author frank
 * @date 2019/03/08
 */
public class ServiceFactory {

    private static Map<Class, Object> serviceFactory = Maps.newHashMap();

    static {
        // 进行包扫描，生产Service放进工厂
        ServiceOne serviceOne = new ServiceOne();
        serviceFactory.put(serviceOne.getClass(), serviceOne);
    }

    public static <T> T getService(Class<T> tClass){
        return (T)serviceFactory.get(tClass);
    }
}
