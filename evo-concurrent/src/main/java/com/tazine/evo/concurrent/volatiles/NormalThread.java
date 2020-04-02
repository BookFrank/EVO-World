package com.tazine.evo.concurrent.volatiles;

/**
 * @author jiaer.ly
 * @date 2020/03/30
 */
public class NormalThread extends Thread {

    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (flag){
            System.out.println("NormalThread print : Tabobao");
            try {
                Thread.sleep(1000 * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
