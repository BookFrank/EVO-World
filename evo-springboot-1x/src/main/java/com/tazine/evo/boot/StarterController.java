package com.tazine.evo.boot;

//import com.tazine.evo.infrastructure.TestBean;
import com.tazine.evo.infrastructure.starter.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author frank
 * @date 2019/05/28
 */
@RestController
public class StarterController {

    private final TestService testService;

    public StarterController(TestService testService) {this.testService = testService;}

    @RequestMapping("/h")
    public String hi(){
        return testService.hi();
    }
}
