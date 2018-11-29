package com.tazine.evo.file.prototuff;

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
    }
}
