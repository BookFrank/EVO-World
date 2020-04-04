package com.tazine.evo.async.jvm;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * 异步只有非阻塞
 *
 * @author jiaer.ly
 * @date 2020/04/03
 */
public class AsyncNonBlocking {

    public void exec(){
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    Thread.sleep(1000 * 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "halo from AsyncNonBlocking";
            }
        });

        future.whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) {
                Test.callback(s);
            }
        });
    }
}
