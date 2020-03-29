package com.tazine.evo.async.concurrent;

import java.util.concurrent.Future;

/**
 * 同步非阻塞调用，最常见的就是轮询
 *
 * @author jiaer.ly
 * @date 2018/03/20
 */
public class SyncNonBlocking {

    /**
     * 同步非阻塞调用，
     *
     * @return string
     */
    public Future exec() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程，");
        });
        return null;
    }
}
