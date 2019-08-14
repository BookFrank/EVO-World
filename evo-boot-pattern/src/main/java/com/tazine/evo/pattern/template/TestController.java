package com.tazine.evo.pattern.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiaer.ly
 * @date 2019/08/14
 */
@RestController
public class TestController {

    @Autowired
    private ServiceOne serviceOne;

    @RequestMapping("/test")
    public String test(){
        serviceOne.process();
        return "test";
    }
}
