package com.tazine.evo.test;

import com.jiaer.common.collect.Maps;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jiaer.ly
 * @date 2018/10/11
 */
public class Test {

    public static void main(String[] args) {

        Map<String, String> busSrcNameMap = Maps.newHashMap();
        busSrcNameMap.put("beijing", "北京");
        busSrcNameMap.put("tianjin", "天津");
        busSrcNameMap.put("shanghai", "上海");
        busSrcNameMap.put("yuncheng", "运城");
        busSrcNameMap.put("xian", "西安");
        busSrcNameMap.put("xianggang", "香港");
        busSrcNameMap.put("dalian", "大连");
        busSrcNameMap.put("sanya", "三亚");
        busSrcNameMap.put("shenzhen", "深圳");
        busSrcNameMap.put("qingdao", "青岛");

        Map<String, Integer> weeklyBusData = Maps.newHashMap();
        for (int i = 0; i < 100; i++) {
            weeklyBusData.put("src_" + i, new Random().nextInt(10000));
        }

        AtomicInteger ai = new AtomicInteger(0);
        weeklyBusData.forEach((k, v) -> {
            ai.addAndGet(v);
            //System.out.println(k + " - " + v);
        });

        System.out.println(ai.get());

        Map<String, Integer> prettyBusMap = com.google.common.collect.Maps.newHashMapWithExpectedSize(20);
        if (!weeklyBusData.isEmpty() && weeklyBusData.size() > 7) {
            int othersTotalNum = 0;
            List<Map.Entry<String, Integer>> list = new ArrayList<>(weeklyBusData.entrySet());
            list.sort((o1, o2) -> {
                return o2.getValue().compareTo(o1.getValue());
            });
            int displayNum = 5;
            for (Map.Entry<String, Integer> entry : list) {
                if (displayNum == 0) {
                    othersTotalNum += entry.getValue();
                } else {
                    prettyBusMap.put(entry.getKey(), entry.getValue());
                    displayNum--;
                }
            }
            prettyBusMap.put("其它", othersTotalNum);
        } else {
            prettyBusMap = weeklyBusData;
        }

        prettyBusMap.forEach((k,v) -> {
            System.out.println(k + " - " + v);
        });

    }

    private void test() {
        URL areaUrl = Test.class.getClassLoader().getResource("area.csv");
        System.out.println(areaUrl.getFile());
        System.out.println(areaUrl.getPath());
        try {
            List<String> nameLines = FileUtils.readLines(new File(areaUrl.getFile()), "UTF-8");

            nameLines.forEach(line -> {
                String[] strArr = line.split(",");
                System.out.println(strArr[0] + " - " + strArr[1]);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
