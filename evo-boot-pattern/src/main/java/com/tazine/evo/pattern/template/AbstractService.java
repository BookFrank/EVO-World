package com.tazine.evo.pattern.template;

import com.tazine.evo.pattern.TestBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author frank
 * @date 2019/08/14
 */
public abstract class AbstractService {

    @Autowired
    public TestBean testBean;

    abstract String getSrvName();

    final void process() {
        testBean.test(getSrvName());
    }
}
