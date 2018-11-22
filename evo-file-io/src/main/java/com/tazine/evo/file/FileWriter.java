package com.tazine.evo.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author frank
 * @date 2018/11/21
 */
public class FileWriter {

    public static void main(String[] args) {

        File file = new File("/Users/jiaer.ly/Desktop/lyg.csv");
        try {

            List<String> list = new ArrayList<>();
            // Commons-io 读取文件
            for (int i = 0; i< 10; i++){
                list.add("" + i);
            }
            FileUtils.writeLines(file, list);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
