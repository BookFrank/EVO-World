package com.tazine.evo.async.web.webflux;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * FunctionPlayerHandler
 *
 * @author jiaer.ly
 * @date 2020/04/05
 */
public class FunctionPlayerHandler {

    /**
     * 业务线程池
     */
    private static final ThreadPoolExecutor BIZ_POOL = new ThreadPoolExecutor(1, 2, 1, TimeUnit.MINUTES,
        new LinkedBlockingQueue<>(10));

    Mono<ServerResponse> playerList(ServerRequest serverRequest) {
        // 1. 根据 request 查找 player 列表
        Flux<String> playerList = Flux.just("kobe", "james")
            .publishOn(Schedulers.fromExecutor(BIZ_POOL))
            .map(v -> {
                System.out.println(Thread.currentThread().getName() + " exec func");
                return v;
            });

        // 2. 返回查找结果
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
            .body(playerList, String.class);
    }
}
