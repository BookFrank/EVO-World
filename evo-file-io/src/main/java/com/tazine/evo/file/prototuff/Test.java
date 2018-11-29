package com.tazine.evo.file.prototuff;

import java.util.ArrayList;
import java.util.List;

/**
 * ProtoStuff Test
 *
 * @author frank
 * @date 2018/11/29
 */
public class Test {

    public static void main(String[] args) {

        Player kobe = Player.builder()
            .name("kobe")
            .team("lakers")
            .num(24).build();

        byte[] data = ProtostuffUtils.serialize(kobe);

        Player rec = ProtostuffUtils.deserialize(data, Player.class);
        System.out.println(rec.toString());

        // ProtoStuff 序列/反序列 List Map 对象时，需要使用 POJO 封装
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Player p = Player.builder().name(i + "号").team("i" + "队").num(i).build();
            players.add(p);
        }

        Team team = Team.builder().players(players).build();

        byte[] datas = ProtostuffUtils.serialize(team);
        Team result = ProtostuffUtils.deserialize(datas, Team.class);
        System.out.println(result);
    }
}
