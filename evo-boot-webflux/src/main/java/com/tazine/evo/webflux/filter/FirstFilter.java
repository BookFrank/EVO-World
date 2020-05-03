package com.tazine.evo.webflux.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author jiaer.ly
 * @date 2020/04/21
 */
@Order(-1)
@Configuration
public class FirstFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain webFilterChain) {

        ServerHttpRequest request = exchange.getRequest();

        System.out.println(request.getPath());

        ServerHttpResponse originalResp = exchange.getResponse();


        //originalResp.writeWith()

        //exchange.getResponse().writeWith(
        //    Flux.just(
        //        exchange.getResponse()
        //            .bufferFactory()
        //            .wrap()
        //    )
        //);

        return webFilterChain.filter(exchange);
    }
}
