package com.tazine.evo.file;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by frank on 2019/2/26.
 *
 * @author frank
 * @date 2019/2/26
 */
public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {

        // /Users/lina/codeplay/github/evo-world/evo-file-io/target/classes/com/tazine/evo/file/
        // /Users/lina/codeplay/github/evo-world/evo-file-io/target/classes/

        // Class 与 ClassLoader 的不同
        String path1 = Test.class.getResource("").getPath();
        String path2 = Test.class.getClassLoader().getResource("").getPath();

        System.out.println(path1);
        System.out.println(path2);


        String s1 = "hello";
        String bk = "\r\n";
        String s2 = "world";
        System.out.println(s1 + bk + s2);

        System.out.println(Arrays.toString(bk.getBytes()));
        System.out.println(Arrays.toString(bk.getBytes("GBK")));

    }

}
