package com.tazine.evo.async.web.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * WebFluxController
 *
 * @author jiaer.ly
 * @date 2020/04/05
 */
@RestController
public class AnnotatedController {

    /**
     * 业务线程池
     */
    private static final ThreadPoolExecutor BIZ_POOL = new ThreadPoolExecutor(1, 2, 1, TimeUnit.MINUTES,
        new LinkedBlockingQueue<>(10));

    /**
     * 默认使用的是 Netty WorkGroup 线程组执行控制器的
     *
     * @return flux
     */
    @GetMapping("/player/list")
    Flux<String> getPlayers() {
        Flux<String> flux = Flux.just("kobe", "james")
            .map(v -> {
                try {
                    Thread.sleep(1000 * 2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " exec func");
                return v;
            });

        System.out.println(Thread.currentThread().getName() + " go go go");
        return flux;
    }

    /**
     * 在 Flux 流上调用 publishOn 让后续对元素的处理切换到线程池，让 Netty 的 IO 线程可以被及时释放
     *
     * @return flux
     */
    @GetMapping("/player")
    Flux<String> playerList() {
        Flux<String> flux = Flux.just("kobe", "james")
            .publishOn(Schedulers.elastic())
            .map(v -> {
                try {
                    Thread.sleep(1000 * 2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " exec func");
                return v;
            });
        System.out.println(Thread.currentThread().getName() + " go go go");
        return flux;
    }

    /**
     * 使用业务线程池
     *
     * @return flux
     */
    @GetMapping("/players")
    Flux<String> players() {
        return Flux.just("kobe", "james")
            .publishOn(Schedulers.fromExecutor(BIZ_POOL))
            .map(v -> {
                System.out.println(Thread.currentThread().getName() + " exec func");
                return v;
            });
    }
}
