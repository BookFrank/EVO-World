package com.tazine.evo.reactive.webflux;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * HandlerFunction 容器
 *
 * @author frank
 * @date 2019/4/8
 */
@Component
public class TimeHandler {

    /**
     * 返回包含时间字符串的ServerResponse
     */
    HandlerFunction<ServerResponse> timeFunction =
            request -> ok().contentType(MediaType.TEXT_PLAIN).body(
                    Mono.just("Now is " + new SimpleDateFormat("HH:mm:ss").format(new Date())), String.class);

    /**
     * 返回包含日期字符串的ServerResponse
     */
    HandlerFunction<ServerResponse> dateFunction =
            request -> ok().contentType(MediaType.TEXT_PLAIN).body(
                    Mono.just("Today is " + new SimpleDateFormat("yyyy-MM-dd").format(new Date())), String.class);

    public Mono<ServerResponse> getTime(ServerRequest serverRequest) {
        return ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("Now is " + new SimpleDateFormat("HH:mm:ss").format(new Date())), String.class);
    }

    public Mono<ServerResponse> getDate(ServerRequest serverRequest) {
        return ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("Today is " + new SimpleDateFormat("yyyy-MM-dd").format(new Date())), String.class);
    }
}
