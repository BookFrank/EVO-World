package com.tazine.evo.boot.controller;

import com.tazine.evo.boot.aop.CustomAop;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AOPController
 *
 * @author frank
 * @date 2019/05/15
 */
@RestController
public class AOPController {

    @Autowired
    private AOPService aopService;

    //@Autowired
    //private AOPController aopController;

    @Autowired
    private ApplicationContext context;

    /**
     * 直接在此AOP是生效的
     *
     * @param s 参数
     * @return String
     */
    //@CustomAop
    @RequestMapping("/aop")
    public String aop(String s) {
        // 直接调用 saySth() 是当前对象调用，不是代理对象，AOP无法生效
        String a = saySth("aop");

        // 解决办法一：通过 AOPController 调用是代理对象，调用AOP才会生效
        //aopController.saySth(s);

        // 解决办法二：代理模式为JDK的情况下根据接口代理
        //context.getBean(AOPController.class).saySth(s);

        // 解决办法三：@EnableAspectJAutoProxy(exposeProxy = true)，需要保证Spring对这个Bean创建了代理对象，基本上涉及到Aop方法的类，都会创建代理对象

        //aopService.doSth(s);
        return s;
    }

    /**
     * 修饰符为 private 时无法代理
     *
     * @param word word
     * @return String
     */
    @CustomAop
    public String saySth(String word) {
        System.out.println("say sth");
        return word;
    }
}
