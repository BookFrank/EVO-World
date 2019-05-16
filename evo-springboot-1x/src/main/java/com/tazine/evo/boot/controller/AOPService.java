package com.tazine.evo.boot.controller;

import org.springframework.stereotype.Service;

/**
 * AOPService
 *
 * @author frank
 * @date 2019/05/16
 */
@Service
public class AOPService {

    //@CustomAop
    public String doSth(String sth) {
        System.out.println("进入 hi");
        return sth;
    }
}
