package com.tazine.evo.boot.ioc.without;

/**
 * ServiceTwo
 *
 * @author frank
 * @date 2019/03/08
 */
public class ServiceTwo {

    private ServiceOne serviceOne = ServiceFactory.getService(ServiceOne.class);

    public void process(){
        System.out.println("Welcome to ServiceTwo");
        serviceOne.process();
    }
}
