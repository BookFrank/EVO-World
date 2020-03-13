package com.tazine.evo.pattern.builder;

/**
 * @author jiaer.ly
 * @date 2020/03/12
 */
public class NbaPlayer {

    private String name;

    private int num;

    public NbaPlayer(String name, int num){
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public static NbaPlayerBuilder builder(){
        return new NbaPlayer.NbaPlayerBuilder();
    }

    public static class NbaPlayerBuilder {
        private String name;
        private int num;

        NbaPlayerBuilder() {
        }

        public NbaPlayer.NbaPlayerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public NbaPlayer.NbaPlayerBuilder num(int num) {
            this.num = num;
            return this;
        }

        public NbaPlayer build() {
            return new NbaPlayer(this.name, this.num);
        }

        public String toString() {
            return "CbaPlayer.CbaPlayerBuilder(name=" + this.name + ", num=" + this.num + ")";
        }
    }
}
