package com.tazine.evo.async.jvm.reactive.rxjava;

import com.tazine.evo.async.NbaPlayer;
import io.reactivex.Flowable;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * Test
 *
 * @author jiaer.ly
 * @date 2020/04/05
 */
public class Test {

    public static void main(String[] args) {

        // 1. 创建 Player 列表
        List<NbaPlayer> players = makeList();

        // 2. 执行过滤和输出
        // 2.1 首先转换 players 列表为流对象
        Flowable.fromArray(players.toArray(new NbaPlayer[0]))
            // 过滤
            .filter(player -> player.getNum() > 20)
            .map(v -> v.getName())
            // 订阅输出
            .subscribe(System.out::println);

        // 当调用 subscribe 进行订阅时（相当于执行JDK8 Stream中的终端操作符）数据流才会流转到不同操作符处进行处理
    }

    private static List<NbaPlayer> makeList() {
        NbaPlayer kobe = new NbaPlayer("kobe", 24);
        NbaPlayer james = new NbaPlayer("james", 23);
        NbaPlayer doncic = new NbaPlayer("doncic", 3);

        List<NbaPlayer> list = Lists.newArrayList();
        list.add(kobe);
        list.add(james);
        list.add(doncic);

        return list;
    }
}
