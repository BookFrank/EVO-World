package com.tazine.evo.annotation.conditional.boot;

/**
 * LocalDomainService
 *
 * @author frank
 * @date 2019/05/01
 */
public class LocalDomainService implements DomainService {

    @Override
    public String where() {
        return "Local";
    }
}
