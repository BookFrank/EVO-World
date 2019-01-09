package com.tazine.evo.netty.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 * @author frank
 * @date 2019/01/09
 */
@RestController
public class TestController {

    @RequestMapping("/hi")
    public String hi(){
        return "Hello World";
    }


}
