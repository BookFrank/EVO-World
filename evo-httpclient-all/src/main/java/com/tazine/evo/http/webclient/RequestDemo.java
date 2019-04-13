package com.tazine.evo.http.webclient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Created by frank on 2019-04-13.
 *
 * @author frank
 * @date 2019-04-13
 */
@RestController
public class RequestDemo {

    @RequestMapping("/webclient")
    public String hi() {
        WebClient webClient = WebClient.create();

        Mono<String> resp = webClient.get()
                .uri("https://www.baidu.com")
                .retrieve()
                .bodyToMono(String.class);
        return resp.block();
    }
}
