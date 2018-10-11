package com.tazine.evo.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 *
 * @author frank
 * @date 2018/10/11
 */
public class FileReader {

    public static void main(String[] args) {
        URL url = FileReader.class.getClassLoader().getResource("area.csv");
        try {
            // Commons-io 读取文件
            List<String> list =  FileUtils.readLines(new File(url.getFile()), "UTF-8");
            list.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
