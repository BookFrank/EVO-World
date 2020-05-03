package com.tazine.evo.webflux.api;

import reactor.core.publisher.Mono;

/**
 * @author jiaer.ly
 * @date 2020/04/23
 */
public class MonoApiDemo {

    public static void main(String[] args) {

        Mono.just("success").subscribe(System.out::println);

    }

}
