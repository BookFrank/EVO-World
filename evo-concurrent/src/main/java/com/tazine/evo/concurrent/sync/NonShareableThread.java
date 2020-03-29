package com.tazine.evo.concurrent.sync;

/**
 * 不共享数据的线程
 *
 * @author jiaer.ly
 * @date 2020/03/29
 */
public class NonShareableThread extends Thread {

    private int count = 5;

    public NonShareableThread(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        while (count > 0){
            count--;
            System.out.println("线程-" + this.getName() + " 计算，count=" + count);
        }
    }
}
