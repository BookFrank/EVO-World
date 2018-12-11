package com.tazine.evo.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * JdkFileIO
 *
 * @author frank
 * @date 2018/09/20
 */
public class JdkFileIO {

    public static void main(String[] args) {

        try {

            Path path = Paths.get("/Users/jiaer.ly/Desktop/test.txt");

            System.out.println(path.toString());

            System.out.println(path.getFileSystem());

            List<String> lines = Files.readAllLines(path);

            lines.forEach(line -> {
                System.out.println(line);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
