package com.tazine.evo.file.encode;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.buf.HexUtils;

import java.io.File;
import java.io.IOException;

/**
 * 文件编码
 *
 * @author frank
 * @date 2019/04/02
 */
public class FileEncode {

    public static void main(String[] args) throws IOException {

        String fileName = "/Users/jiaer.ly/Desktop/encode";
        File file = new File(fileName);

        String s1 = "中";
        System.out.println(HexUtils.toHexString(s1.getBytes()));
        // "中" 十六进制显示： e4b8ad

        for (byte b : s1.getBytes()){
            System.out.print(Integer.toBinaryString((b & 0xFF) + 0x100).substring(1) + " ");
        }
        // "中" 转换为二进制： 11100100 10111000 10101101
        System.out.println();

        byte bs = "0".getBytes()[0];
        System.out.println(Integer.toBinaryString((bs & 0xFF) + 0x100).substring(1));
        System.out.println(HexUtils.toHexString("0".getBytes()));
        // "h" 二进制显示： 01101000
        // "0" 二进制显示： 01100000  Hex显示：30

        FileUtils.writeByteArrayToFile(file, s1.getBytes());
    }
}
