package com.tazine.evo.reactive.webflux;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * HelloController
 *
 * @author frank
 * @date 2019/4/8
 */
@RestController
public class HelloController {

    @RequestMapping("/hi")
    public Mono<String> hi(){
        return Mono.just("hello webflux");
    }
}
