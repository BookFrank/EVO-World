package com.tazine.evo.file.path;

/**
 * FilePathDemo
 *
 * @author frank
 * @date 2019/03/01
 */
public class FilePathDemo {

    public static void main(String[] args) {

        String path1 = FilePathDemo.class.getResource("").getPath();
        String path2 = FilePathDemo.class.getResource("/").getPath();

        // /target/classes/com/tazine/evo/file/path/
        // /target/classes/
        System.out.println(path1);
        System.out.println(path2);

    }

}
