package com.tazine.evo.boot2.contoller;

import com.tazine.evo.boot2.entity.PlayerDO;
import com.tazine.evo.boot2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author frank
 * @date 2019/10/21
 */
@RestController
public class TestRestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public List<PlayerDO> list(@RequestParam(name = "name", required = true) String name){
        //throw new RuntimeException("error");
        return testService.players();
    }
}
