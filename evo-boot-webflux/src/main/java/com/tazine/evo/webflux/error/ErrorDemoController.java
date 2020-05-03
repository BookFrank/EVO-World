package com.tazine.evo.webflux.error;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiaer.ly
 * @date 2020/04/23
 */
@RestController
public class ErrorDemoController {

    @RequestMapping("/hi")
    public Integer hi(String s){
        return Integer.parseInt(s);
    }
}
