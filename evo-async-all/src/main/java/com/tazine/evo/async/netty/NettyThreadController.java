package com.tazine.evo.async.netty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * NettyThreadController
 *
 * @author frank
 * @date 2019/08/21
 */
@Slf4j
@RestController
@RequestMapping("/netty")
public class NettyThreadController {

    @RequestMapping("/sync")
    public Mono<String> sync() throws InterruptedException {
        log.info("sync");
        TimeUnit.DAYS.sleep(1);
        return Mono.just("hello world");
    }
}
