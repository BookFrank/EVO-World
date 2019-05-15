package com.tazine.evo.file.encode;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
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

        for (byte b : defaultrr) {
            System.out.println(byteToBit(b));
        }
        System.out.println(binary(defaultrr, 2));

        // 将 utf8 编码字符串转成 gbk

        // Integer.toBinaryString(int i) 返回参数数值的补码形式，正数则忽略前面的0
        // 返回传入参数的一个无符号的二进制字符串
        Integer i1 = 10;
        System.out.println(Integer.toBinaryString(10)); // 输出1010
        System.out.println(Integer.toBinaryString(-10)); // 11111111111111111111111111110110

    }

    /**
     * 将byte[]转为各种进制的字符串
     *
     * @param bytes byte[]
     * @param radix 基数可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX，超出范围后变为10进制
     * @return 转换后的字符串
     */
    public static String binary(byte[] bytes, int radix) {
        return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数
    }

    /**
     * 将byte转换为一个长度为8的byte数组，数组每个值代表bit
     */
    public static byte[] getBooleanArray(byte b) {
        byte[] array = new byte[8];
        for (int i = 7; i >= 0; i--) {
            array[i] = (byte)(b & 1);
            b = (byte)(b >> 1);
        }
        return array;
    }

    /**
     * 把byte转为字符串的bit
     */
    public static String byteToBit(byte b) {
        return ""
            + (byte)((b >> 7) & 0x1) + (byte)((b >> 6) & 0x1)
            + (byte)((b >> 5) & 0x1) + (byte)((b >> 4) & 0x1)
            + (byte)((b >> 3) & 0x1) + (byte)((b >> 2) & 0x1)
            + (byte)((b >> 1) & 0x1) + (byte)((b >> 0) & 0x1);

    }
}