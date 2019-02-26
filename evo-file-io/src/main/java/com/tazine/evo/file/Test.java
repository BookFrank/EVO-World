package com.tazine.evo.file;

/**
 * Created by frank on 2019/2/26.
 *
 * @author frank
 * @date 2019/2/26
 */
public class Test {

    public static void main(String[] args) {

        // Class 与 ClassLoader 的不同
        String path1 = Test.class.getResource("").getPath();
        String path2 = Test.class.getClassLoader().getResource("").getPath();

        System.out.println(path1);
        System.out.println(path2);

    }

}
