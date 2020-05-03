package com.tazine.evo.webflux.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebExchangeDecorator;

/**
 * @author jiaer.ly
 * @date 2020/05/01
 */
public class EvoServerWebExchangeDecorator extends ServerWebExchangeDecorator {

    private EvoServerHttpResponseDecorator responseDecorator;

    public EvoServerWebExchangeDecorator(ServerWebExchange delegate) {
        super(delegate);
        this.responseDecorator = new EvoServerHttpResponseDecorator(delegate.getResponse());
    }

    @Override
    public ServerHttpResponse getResponse() {
        return responseDecorator;
    }
}
