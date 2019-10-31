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
public class BeanTestController {

    @Autowired
    private TestBean bean1;

    @RequestMapping("/proto")
    public String hash(){
        //ContextUtil.getBeanDefinition();
        TestBean bean2 = ContextUtil.getBean(TestBean.class);
        TestBean bean3 = ContextUtil.getBean(TestBean.class);

        ContextUtil.getBeansMapOfType(TestBean.class);

        // 当 TestBean 为 singleton 时，三个是同一个 bean


        // 当 TestBean 为 prototype 时，三个是不同的 bean
        return bean1.hashCode() + " - " + bean2.hashCode() + " - " + bean3.hashCode() + " - " + ContextUtil.getBean(TestBean.class).hashCode() + " - " + ContextUtil.getBean("testBean").hashCode();
    }
}
