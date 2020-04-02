package com.tazine.evo.concurrent.webflux;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author jiaer.ly
 * @date 2020/03/26
 */
@Configuration
public class Router {

    @Bean
    public RouterFunction<ServerResponse> routeCity(CityHandler cityHandler) {
        System.err.println("Controller Thread: " + Thread.currentThread().getName());
        return RouterFunctions
            .route(RequestPredicates.GET("/hello")
                    .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), cityHandler::helloCity);
    }
}
