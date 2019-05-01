package com.tazine.evo.annotation.conditional.boot;

/**
 * HongKongService
 *
 * @author frank
 * @date 2019/05/01
 */
public class HongKongDomainService implements DomainService {

    @Override
    public String where() {
        return "HK";
    }
}
