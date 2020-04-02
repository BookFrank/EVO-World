package com.tazine.evo.concurrent.webflux;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author jiaer.ly
 * @date 2020/03/26
 */
@Component
public class CityHandler {

    public Mono<ServerResponse> helloCity(ServerRequest request) {
        System.out.println("Service Thread: " + Thread.currentThread().getName());

        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
            .body(BodyInserters.fromObject("Hello, City!"));
    }
}
