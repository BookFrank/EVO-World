package com.tazine.evo.boot2.contoller;

import com.tazine.evo.boot2.entity.PlayerDO;
import com.tazine.evo.boot2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author jiaer.ly
 * @date 2019/10/22
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test1")
    //@ResponseBody
    public List<PlayerDO> list(@RequestParam(name = "name", required = true) String name){
        //throw new RuntimeException("error");
        return testService.players();
    }

}
