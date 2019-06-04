package com.tazine.evo.boot.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiaer.ly
 * @date 2019/06/03
 */
@RestController
public class TestConfController {

    @Autowired
    private MultiDruidProperties multiDruidProperties;

    @Autowired
    private DruidProperties druidProperties;

    @RequestMapping("/multi")
    public MultiDruidProperties get(){
        return multiDruidProperties;
    }

    @RequestMapping("/druid")
    public DruidProperties getD(){
        return druidProperties;
    }
}
