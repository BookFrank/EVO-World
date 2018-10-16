package com.tazine.evo.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * @author frank
 * @date 2018/10/11
 */
public class FileReader {

    public static void main(String[] args) {
        readTest();
        //resourceRead();
    }

    private static void readTest() {
        System.out.println(FileReader.class.getResource("a.txt"));
        System.out.println(FileReader.class.getResource("/a.txt"));
        System.out.println(FileReader.class.getResource("/"));
        System.out.println(FileReader.class.getResource("b.txt"));
        System.out.println();

        // need to add resource/b.txt to build path! it will be package in jar file
        System.out.println(FileReader.class.getClassLoader().getResource("a.txt"));
        System.out.println(FileReader.class.getClassLoader().getResource("/a.txt"));
        System.out.println(FileReader.class.getClassLoader().getResource("/"));
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("a.txt"));
    }

    /**
     * Resources.read
     */
    private static void resourceRead() {
        URL url = FileReader.class.getClassLoader().getResource("area.csv");
        try {
            // Commons-io 读取文件
            List<String> list = FileUtils.readLines(new File(url.getFile()), "UTF-8");
            list.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void classLoaderResourceRead() {
        URL url = FileReader.class.getClassLoader().getResource("area.csv");
        try {
            // Commons-io 读取文件
            List<String> list = FileUtils.readLines(new File(url.getFile()), "UTF-8");
            list.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
