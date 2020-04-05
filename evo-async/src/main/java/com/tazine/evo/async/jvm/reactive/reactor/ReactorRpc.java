package com.tazine.evo.async.jvm.reactive.reactor;

/**
 * @author jiaer.ly
 * @date 2020/04/05
 */
public class ReactorRpc {

    public static void main(String[] args) {



    }

    private static String rpcCall(String ip, String param) {

        System.out.println(Thread.currentThread().getName() + " " + ip + " ,rpcCall:" + param);
        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return param;
    }
}
