package com.tazine.evo.pattern.template;

import org.springframework.stereotype.Component;

/**
 * @author frank
 * @date 2019/08/14
 */
@Component
public class ServiceOne extends AbstractService {

    @Override
    String getSrvName() {
        testBean.test("haha");
        return "serviceA";
    }
}
