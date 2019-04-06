package com.tazine.evo.reactive.lambda;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

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

        // 1. 不使用 lambda
        NCAAPlayer kevin = new NCAAPlayer("kevin", 25.0, 2.1);
        NCAAPlayer zion = new NCAAPlayer("zion", 31.0, 1.98);
        NCAAPlayer james = new NCAAPlayer("james", 21.0, 1.92);

        List<NCAAPlayer> players = Lists.newArrayList(kevin, zion, james);
        players.forEach(p -> {
            System.out.println(p.getName() + " - " + p.getAvgScore());
        });

        // sort方法需要的只是一种用于比较的逻辑，因为Java面向对象，这个逻辑必须包装在一个对象中
        players.sort(new DraftCompare());
        System.out.println();
        players.forEach(p -> {
            System.out.println(p.getName() + " - " + p.getAvgScore());
        });
        System.out.println();

        // 2. 使用lambda
        // 上面的场景我们定义了一个对赛季平均得分排序Comparator，但是我们想对身高排序时就需要再定一个身高的Comparator
        // “传统”的简化方式是直接传入匿名内部类，但其实，我们会发现，无论哪种比较策略，只有compare方法内的代码发生变化，也就是说sort方法关心的只是传入的两个参数Student s1, Student s2以及返回的结论return Double.compare(s1.getHeight(), s2.getHeight())这一句比较策略，何不只保留它们呢？
        players.sort(Comparator.comparingDouble(NCAAPlayer::getHeight));
        players.forEach(p -> {
            System.out.println(p.getName() + " - " + p.getHeight());
        });
    }
}

@Data
@AllArgsConstructor
class NCAAPlayer {

    private String name;

    private Double avgScore;

    private Double height;

    public NCAAPlayer(String name, Double avgScore) {
        this.name = name;
        this.avgScore = avgScore;
    }
}

class DraftCompare implements Comparator<NCAAPlayer> {

    @Override
    public int compare(NCAAPlayer o1, NCAAPlayer o2) {
        return Double.compare(o1.getAvgScore(), o2.getAvgScore());
    }
}
