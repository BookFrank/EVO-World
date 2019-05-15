package com.tazine.evo.file.encode;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * GbkEncode
 *
 * @author frank
 * @date 2019/05/15
 */
public class GbkEncode {

    public static void main(String[] args) throws UnsupportedEncodingException {
        
        System.out.println(Charset.defaultCharset().displayName());

        String s = "嘉尔";

        byte[] defaultrr = s.getBytes();
        byte[] gbkArr = s.getBytes("GBK");
        byte[] utfArr = s.getBytes("utf-8");

        System.out.println(Arrays.toString(gbkArr));
        System.out.println(Arrays.toString(utfArr));

        // 将 utf8 编码字符串转成 gbk


        // Integer.toBinaryString(int i) 返回参数数值的补码形式，正数则忽略前面的0
        // 返回传入参数的一个无符号的二进制字符串
        Integer i1 = 10;
        System.out.println(Integer.toBinaryString(10)); // 输出1010
        System.out.println(Integer.toBinaryString(-10)); // 11111111111111111111111111110110
    }
}
