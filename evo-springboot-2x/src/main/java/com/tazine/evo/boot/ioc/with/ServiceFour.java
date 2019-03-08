package com.tazine.evo.boot.ioc.with;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ServiceFour
 *
 * @author frank
 * @date 2019/03/08
 */
@Service
public class ServiceFour {

    @Autowired
    private ServiceThree serviceThree;

    public void process(){
        System.out.println("Welcome to ServiceFour");
        serviceThree.process();
    }
}
