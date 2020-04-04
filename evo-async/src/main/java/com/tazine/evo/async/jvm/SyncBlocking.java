package com.tazine.evo.async.jvm;

/**
 * SyncBlocking
 *
 * @author jiaer.ly
 * @date 2020/04/03
 */
public class SyncBlocking {

    public String exec() {
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Halo from the SyncBlocking";
    }
}
