package com.tazine.evo.boot2.contoller;

import com.tazine.evo.boot2.rest.EvoJsonResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiaer.ly
 * @date 2019/11/29
 */
@RestController
public class RtMetricController {

    @EvoJsonResponse
    @RequestMapping("/met")
    public String metric(String clientKey){
        return clientKey;
    }
}
