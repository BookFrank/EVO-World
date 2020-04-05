package com.tazine.evo.async.jvm.reactive.reactor;

import com.tazine.evo.async.NbaPlayer;
import org.apache.commons.compress.utils.Lists;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author jiaer.ly
 * @date 2020/04/05
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        //test();

        sync();

        Thread.currentThread().join();
    }

    private static void sync() {
        // 1. 创建 Player 列表
        List<NbaPlayer> players = makeList();

        // 2. 并发调用
        Flux.fromArray(players.toArray(new NbaPlayer[0]))
            .flatMap(p ->
                Flux.just(p)
                    .subscribeOn(Schedulers.elastic())
                    .map(v -> call(v))
            )
            // 订阅输出
            .subscribe(new Consumer<String>() {
                @Override
                public void accept(String s) {
                    System.out.println(Thread.currentThread().getName() + " " + s);
                }
            });
    }

    private static String call(NbaPlayer player) {
        try {
            System.out.println(Thread.currentThread().getName() + " call");
            Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return player.getName() + ", team is " + player.getTeam();
    }

    private static void test() {
        // 1. 创建 Player 列表
        List<NbaPlayer> players = makeList();

        // 2. 执行过滤和输出
        // 使用 flux 获取流对象
        Flux.fromArray(players.toArray(new NbaPlayer[0]))
            // 过滤
            .filter(p -> p.getNum() > 20)
            // 映射转换
            .map(p -> p.getName())
            // 订阅输出
            .subscribe(System.out::println);
    }

    private static List<NbaPlayer> makeList() {
        NbaPlayer james = new NbaPlayer("james", 23, "lakers");
        NbaPlayer kobe = new NbaPlayer("kobe", 24, "lakers");
        NbaPlayer doncic = new NbaPlayer("doncic", 3, "mavs");
        NbaPlayer iverson = new NbaPlayer("iverson", 3, "76ers");
        NbaPlayer tracy = new NbaPlayer("tracy", 3, "rockets");
        NbaPlayer irving = new NbaPlayer("irving", 3, "nets");

        List<NbaPlayer> list = Lists.newArrayList();
        list.add(kobe);
        list.add(james);
        list.add(doncic);
        list.add(iverson);
        list.add(tracy);
        list.add(irving);

        return list;
    }
}
