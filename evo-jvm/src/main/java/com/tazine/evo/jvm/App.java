package com.tazine.evo.jvm;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        {
            byte[] bs = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }
}
