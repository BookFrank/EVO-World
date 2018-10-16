package com.tazine.evo.test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * @author jiaer.ly
 * @date 2018/10/11
 */
public class Test {

    public static void main(String[] args) {
        URL areaUrl = com.jiaer.Test.class.getClassLoader().getResource("area.csv");
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
