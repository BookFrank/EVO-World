package com.tazine.evo.ml.cluster.dbscan;

import java.util.ArrayList;

/**
 * @author jiaer.ly
 * @date 2019/11/06
 */
public class Test {

    public static void main(String[] args) {
        //ArrayList<Point> points = Data.generateSinData(200);
        //DBScan dbScan = new DBScan(0.6,4);
        ArrayList<Point> points = generateSpecialData();
        DBScan dbScan = new DBScan(1.0,2);
        dbScan.process(points);
        for (Point p:points) {
            System.out.println(p);
        }
    }

    public static ArrayList<Point> generateSpecialData() {
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(24.6,0));
        points.add(new Point(25,0));
        points.add(new Point(25,0));
        points.add(new Point(27.2,0));
        points.add(new Point(30.1,0));
        points.add(new Point(20.7,0));
        points.add(new Point(30.1,0));
        points.add(new Point(23.7,0));
        points.add(new Point(21,0));
        points.add(new Point(21.8,0));
        points.add(new Point(19,0));
        points.add(new Point(17.8,0));
        points.add(new Point(24.5,0));
        points.add(new Point(21,0));
        points.add(new Point(20.5,0));
        points.add(new Point(25,0));
        points.add(new Point(21,0));
        points.add(new Point(26,0));
        points.add(new Point(23,0));
        points.add(new Point(24.5,0));
        points.add(new Point(21,0));
        points.add(new Point(20.5,0));
        points.add(new Point(21,0));
        points.add(new Point(26,0));
        points.add(new Point(23,0));
        points.add(new Point(24.5,0));
        points.add(new Point(21,0));
        points.add(new Point(20.5,0));
        points.add(new Point(25,0));
        points.add(new Point(21,0));
        points.add(new Point(26,0));
        points.add(new Point(23,0));
        points.add(new Point(22.3,0));
        points.add(new Point(21.8,0));
        points.add(new Point(23.1,0));
        points.add(new Point(28,0));
        points.add(new Point(31.2,0));
        points.add(new Point(23.6,0));
        points.add(new Point(23,0));
        return points;
    }
}
