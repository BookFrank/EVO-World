package com.tazine.evo.boot2.contoller;

import com.alibaba.fastjson.JSON;
import com.tazine.evo.boot2.entity.PlayerDO;
import com.tazine.evo.boot2.rest.RestResponseBuilder;
import com.tazine.evo.boot2.rest.EvoJsonResponse;
import com.tazine.evo.boot2.rest.entity.HttpResult;
import com.tazine.evo.boot2.service.TestBean;
import com.tazine.evo.boot2.service.TestService;
import com.tazine.evo.boot2.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author frank
 * @date 2019/10/22
 */
//@Controller
@RestController
@Scope("prototype")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private TestBean bean1;

    //@Autowired
    //private TestBean bean2;

    @RequestMapping("/test1")
    //@ResponseBody
    public List<PlayerDO> list(@RequestParam(name = "name", required = true) String name){
        //throw new RuntimeException("error");
        return testService.players();
    }

    @RequestMapping("/kobe")
    @EvoJsonResponse
    public PlayerDO player(){
        return new PlayerDO("kobe", "lakers", 23);
    }

    @RequestMapping("/james")
    @EvoJsonResponse
    public String nba(){
        return "james";
    }

    @RequestMapping("/proto2")
    public String ok(){
        //TestBean bean1 = ContextUtil.getBean(TestBean.class);
        bean1.say();


        //TestBean bean2 = ContextUtil.getBean(TestBean.class);
        //bean2.say();

        //Map<String, TestBean> map = ContextUtil.getBeansOfType(TestBean.class);

        //ContextUtil.getBeanNamesForType(TestBean.class);
        ContextUtil.getBeanDefinition();
        return bean1.hashCode()+"";
    }

    public static void main(String[] args) {
        HttpResult result = RestResponseBuilder.buildSuccessResponse("hello");
        System.out.println(JSON.toJSONString(result));
    }
}
