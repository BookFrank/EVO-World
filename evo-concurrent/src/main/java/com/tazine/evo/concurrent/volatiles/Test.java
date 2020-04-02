package com.tazine.evo.concurrent.volatiles;

/**
 * @author jiaer.ly
 * @date 2020/03/30
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        NormalThread normalThread = new NormalThread();

        VolatileThread volatileThread = new VolatileThread();

        normalThread.start();

        volatileThread.start();

        Thread.sleep(1000 * 15);

        normalThread.setFlag(false);
        volatileThread.setFlag(false);

        Thread.sleep(1000 * 1000);
    }
}
