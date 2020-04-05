package com.tazine.evo.async.web.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * FunctionModelConfig
 *
 * @author jiaer.ly
 * @date 2020/04/05
 */
@Configuration
public class FunctionModelConfig {

    @Bean
    public FunctionPlayerHandler handler() {
        return new FunctionPlayerHandler();
    }

    public RouterFunction<ServerResponse> routerFunction(final FunctionPlayerHandler handler) {
        //RouterFunction<ServerResponse> route = RouterFunctions.route()
        return null;

    }

}
