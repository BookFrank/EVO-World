package com.tazine.evo.netty.zerocopy;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * ZeroFileCopy
 *
 * @author frank
 * @date 2018/12/29
 */
public class ZeroFileCopy {

    public static void main(String[] args) {
        String src = "/Users/jiaer.ly/codeplay/github/file/src.txt";
        String dest = "/Users/jiaer.ly/codeplay/github/file/dest.txt";
    }

    public static void copyFileWrite() {

    }

    public static void copyFileWithFileChannel(String srcFileName, String destFileName) throws Exception {
        RandomAccessFile srcFile = new RandomAccessFile(srcFileName, "r");
        FileChannel srcFileChannel = srcFile.getChannel();

        RandomAccessFile destFile = new RandomAccessFile(destFileName, "rw");
        FileChannel destFileChannel = destFile.getChannel();

        long position = 0;
        long count = srcFileChannel.size();

        srcFileChannel.transferTo(position, count, destFileChannel);
    }
}
