package com.tazine.evo.netty.zerocopy;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * ZeroFileCopy
 *
 * @author frank
 * @date 2018/12/29
 */
public class ZeroFileCopy {

    public static void main(String[] args) throws Exception {
        String src = "/Users/jiaer.ly/codeplay/github/file/src.txt";
        String dest = "/Users/jiaer.ly/codeplay/github/file/dest.txt";
        String dest1 = "/Users/jiaer.ly/codeplay/github/file/dest1.txt";
        String dest2 = "/Users/jiaer.ly/codeplay/github/file/dest2.txt";

        copyFileWrite(src, dest1);
        copyFileWrite1(src, dest2);
        copyFileWithFileChannel(src, dest);
    }

    public static void copyFileWrite(String srcFileName, String destFileName) throws Exception {
        File srcFile = new File(srcFileName);
        File destFile = new File(destFileName);

        BufferedReader reader = new BufferedReader(new FileReader(srcFile));
        FileWriter fileWriter = new FileWriter(destFile);

        // readLine 写出的会与普通复制不太一样
        while (reader.ready()){
            fileWriter.write(reader.readLine());
        }
        fileWriter.flush();
        System.out.println("普通文件复制成功");
    }

    public static void copyFileWrite1(String srcFileName, String destFileName) throws IOException {
        File srcFile = new File(srcFileName);
        File destFile = new File(destFileName);

        FileReader fileReader = new FileReader(srcFile);
        FileWriter fileWriter = new FileWriter(destFile);

        while (fileReader.ready()){
            fileWriter.write(fileReader.read());
        }

        fileWriter.flush();
        System.out.println("普通文件复制成功");
    }

    public static void copyFileWithFileChannel(String srcFileName, String destFileName) throws Exception {
        // 有了 FileChannel 后, 就可以直接将源文件的内容通过transferTo)方法直接拷贝到目的文件中, 而不需要额外借助一个临时 buffer, 避免了不必要的内存操作
        RandomAccessFile srcFile = new RandomAccessFile(srcFileName, "r");
        FileChannel srcFileChannel = srcFile.getChannel();

        RandomAccessFile destFile = new RandomAccessFile(destFileName, "rw");
        FileChannel destFileChannel = destFile.getChannel();

        long position = 0;
        long count = srcFileChannel.size();

        srcFileChannel.transferTo(position, count, destFileChannel);
        System.out.println("文件复制成功");
    }
}
