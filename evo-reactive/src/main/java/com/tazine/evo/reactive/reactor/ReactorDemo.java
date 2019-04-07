package com.tazine.evo.reactive.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * ReactorDemo
 *
 * @author frank
 * @date 2019/04/07
 */
public class ReactorDemo {

    public static void main(String[] args) {

        // 1. 创建数据流，Reactor中的发布者 Publisher 由 Flux 和 Mono 两个类定义

        // 2. 触发订阅关系，Flux.just(1, 2, 3, 4, 5, 6)仅仅声明了这个数据流，此时数据元素并未发出，
        // 只有subscribe()方法调用的时候才会触发数据流。所以，订阅前什么都不会发生
        Flux.just(1,2,3,4,5).subscribe(System.out::print);
        System.out.println();
        Flux.just(1,2,3,4,5).subscribe(
            System.out::print,
            System.out::print,
            () -> System.out.println("completed")
        );
        System.out.println();
        Mono.error(new Exception("some error")).subscribe(
            System.out::println,
            System.err::println,
            () -> System.out.println("Completed!")
        );

    }
}
