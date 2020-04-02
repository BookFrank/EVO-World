package com.tazine.evo.concurrent.pool;

/**
 * @author jiaer.ly
 * @date 2019/04/02
 */
public class Test {

    private final static int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {

        System.out.println(AVAILABLE_PROCESSORS);

    }

}
