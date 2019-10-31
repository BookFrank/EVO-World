package com.tazine.evo.boot2.contoller.bean;

import com.tazine.evo.boot2.service.TestBean;
import com.tazine.evo.boot2.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author frank
 * @date 2019/10/31
 */
@RestController
public class BeanDemoController {

    @Autowired
    private TestBean bean2;

    @RequestMapping("/proto1")
    public int hash(){
        ContextUtil.getBeanDefinition();
        return bean2.hashCode();
    }
}
