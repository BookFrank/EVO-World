package com.tazine.evo.webflux;

/**
 * @author jiaer.ly
 * @date 2020/04/05
 */
public class NbaPlayer {

    private String name;

    private Integer num;

    private String team;

    public NbaPlayer(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    public NbaPlayer(String name, Integer num, String team) {
        this.name = name;
        this.num = num;
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public static void main(String[] args) {


    }
}
