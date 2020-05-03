package com.tazine.evo.webflux;

import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author jiaer.ly
 * @date 2020/04/29
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public Flux test() {

        Flux.just("james","harden")
            .flatMap(new Function<String, Publisher<?>>() {
                @Override
                public Publisher<?> apply(String s) {

                    return null;
                }
            });


        return Flux.just("james", "harden").map(v -> {
            NbaPlayer p = new NbaPlayer(v, 23);
            return p;
        });



        //return Flux.just("hi", "world").map(s -> 1);


    }

    @RequestMapping("/mono")
    public Mono<NbaPlayer> player(){
        NbaPlayer james = new NbaPlayer("james", 23);
        return Mono.just(james);
    }

    @RequestMapping("/str")
    public String str(){
        return "hello world";
    }

    @RequestMapping("/obj")
    public NbaPlayer playe1r(){
        return new NbaPlayer("james", 23);
    }

    @RequestMapping("/void")
    public Mono<Void> voide(){
        //return Mono.empty();
        return null;
    }

    public static void main(String[] args) throws InterruptedException {

        //Flux.just("james", "kobe")
        //    .flatMap(new Function<String, Publisher<?>>() {
        //        @Override
        //        public Publisher<?> apply(String s) {
        //            System.out.println(s);
        //            return null;
        //        }
        //    }).count();
        //
        Flux.just("james", "kobe").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
