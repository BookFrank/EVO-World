package com.tazine.evo.infrastructure;

import com.tazine.evo.infrastructure.common.RestResponseBuilder;
import com.tazine.evo.infrastructure.common.entity.HttpResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author frank
 * @date 2019/04/26
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public HttpResult test(){
        EventImpactVO vo = new EventImpactVO();

        Map<Integer,Integer> map = new HashMap<>();
        map.put(20190425, 31);
        vo.setDetail(map);
        vo.setSEventId("123");
        vo.setTotal(31);
        vo.setSource("event_guangzhou");
        return RestResponseBuilder.buildSuccessResponse(vo);
    }
}
