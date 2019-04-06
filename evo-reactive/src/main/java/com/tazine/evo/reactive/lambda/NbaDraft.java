package com.tazine.evo.reactive.lambda;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

/**
 * NbaDraft
 *
 * @author frank
 * @date 2019/04/06
 */
public class NbaDraft {

    public static void main(String[] args) {
        NCAAPlayer kevin = new NCAAPlayer("kevin", 25.0);
        NCAAPlayer zion = new NCAAPlayer("zion", 31.0);
        NCAAPlayer james = new NCAAPlayer("james", 21.0);

        List<NCAAPlayer> players = Lists.newArrayList(kevin, zion, james);
        players.forEach(p -> {
            System.out.println(p.getName() + " - " + p.getAvgScore());
        });
        players.sort(new DraftCompare());
        System.out.println();
        players.forEach(p -> {
            System.out.println(p.getName() + " - " + p.getAvgScore());
        });
    }
}

class NCAAPlayer {

    private String name;

    private Double avgScore;

    public NCAAPlayer(String name, Double avgScore) {
        this.name = name;
        this.avgScore = avgScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }
}

class DraftCompare implements Comparator<NCAAPlayer> {

    @Override
    public int compare(NCAAPlayer o1, NCAAPlayer o2) {
        return Double.compare(o1.getAvgScore(), o2.getAvgScore());
    }
}
