package com.tazine.evo.annotation.service.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 用于测试 Bean Scope 的服务
 *
 * @author frank
 * @date 2018/09/19
 */
@Service
@Scope("prototype")
public class ScopeService {

    public void test() {
        System.out.println("Hello From ScopeService:" + this.hashCode());
    }

}
