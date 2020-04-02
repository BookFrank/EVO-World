package com.tazine.evo.concurrent.webflux;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @author jiaer.ly
 * @date 2020/03/26
 */
@Slf4j
@RestController
public class FluxController {

    @Autowired
    private FluxService fluxService;

    @RequestMapping("/sync")
    public Mono<String> sync() throws InterruptedException {
        System.err.println("Controller Thread: " + Thread.currentThread().getName());
        return Mono.just(fluxService.hi());
    }

}
