package com.tazine.evo.async.jvm.reactive.rxjava;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * AsyncRpcCall
 *
 * @author jiaer.ly
 * @date 2020/04/05
 */
public class AsyncRpcCall {

    public static void main(String[] args) throws InterruptedException {
        //sync();

        async();

        // 挂起 main 函数所在线程
        Thread.currentThread().start();
    }

    /**
     * 将 RPC 调用由 main 函数切换到 io 线程执行，io 线程内的10个RPC调用还是顺序调用
     */
    private static void async() {

        // 1. 生成 IP 列表
        List<String> ipList = Lists.newArrayList();
        for (int i = 1; i <= 10; ++i) {
            ipList.add("192.168.0." + i);
        }

        // 2. 顺序调用
        long start = System.currentTimeMillis();
        Flowable.fromArray(ipList.toArray(new String[0]))
            // 使用 observeOn 让 rpcCall 的执行由 main 函数所在线程切换到 IO 线程
            .observeOn(Schedulers.io())
            .map(v -> rpcCall(v, v))
            .subscribe(System.out::println);

        // 3. 打印耗时
        System.out.println("cost:" + (System.currentTimeMillis() - start));
    }

    /**
     * main 函数同步执行 10 个 RPC 调用
     */
    private static void sync() {
        // 1. 生成 IP 列表
        List<String> ipList = Lists.newArrayList();
        for (int i = 1; i <= 10; ++i) {
            ipList.add("192.168.0." + i);
        }

        // 2. 顺序调用
        long start = System.currentTimeMillis();
        Flowable.fromArray(ipList.toArray(new String[0]))
            .map(v -> rpcCall(v, v))
            .subscribe(System.out::println);

        // 3. 打印耗时
        System.out.println("cost:" + (System.currentTimeMillis() - start));
    }

    public static String rpcCall(String ip, String param) {

        System.out.println(Thread.currentThread().getName() + " " + ip + " ,rpcCall:" + param);
        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return param;
    }
}
