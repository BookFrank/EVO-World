package com.tazine.evo.file.path;

/**
 * FilePathDemo
 *
 * @author frank
 * @date 2019/03/01
 */
public class FilePathDemo {

    public static void main(String[] args) {

        // Class.getResource(String path)
        // path不以'/'开头时，默认是从此类所在的包下取资源；path以'/'开头时，则是从项目的ClassPath根下获取资源。在这里'/'表示ClassPath
        String path1 = FilePathDemo.class.getResource("").getPath();
        String path2 = FilePathDemo.class.getResource("/").getPath();

        // /target/classes/com/tazine/evo/file/path/
        // /target/classes/
        System.out.println(path1);
        System.out.println(path2);
        System.out.println();


        // Class.getClassLoader().getResource(String path)
        // path不能以'/'开头时，path是指类加载器的加载范围，在资源加载的过程中，使用的逐级向上委托的形式加载的，
        // '/'表示Boot ClassLoader中的加载范围，因为这个类加载器是C++实现的，所以加载范围为null。
        String path3 = FilePathDemo.class.getClassLoader().getResource("").getPath();
        //String path4 = FilePathDemo.class.getClassLoader().getResource("/").getPath();

        // /target/classes/com/tazine/evo/file/path/
        // /target/classes/
        System.out.println(path3);
        //System.out.println(path4);



    }

}
