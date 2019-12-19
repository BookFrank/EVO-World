package com.tazine.evo.boot2.contoller;

import com.tazine.evo.boot2.service.ConstructService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiaer.ly
 * @date 2019/12/19
 */
@RestController
public class ConstructController {

    @RequestMapping("/init")
    public String init(){
        return ConstructService.author;
    }
}
