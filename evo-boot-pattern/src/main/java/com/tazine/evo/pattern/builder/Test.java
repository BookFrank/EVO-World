package com.tazine.evo.pattern.builder;

/**
 * @author jiaer.ly
 * @date 2020/03/12
 */
public class Test {

    public static void main(String[] args) {

        Player kobe = new Player("kobe", 24);

        NbaPlayer james = NbaPlayer.builder()
            .name("james")
            .num(23)
            .build();

        System.out.println(james.getName());

        CbaPlayer yi = CbaPlayer.builder().name("yi").num(11).build();
        System.out.println(yi.getName());
    }

}
