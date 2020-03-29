package com.tazine.evo.concurrent.sync;

/**
 * @author jiaer.ly
 * @date 2020/03/29
 */
public class ShareableThread extends Thread{

    private Integer count;

    public ShareableThread(Integer count, String name) {
        this.count = count;
        this.setName(name);
    }

    @Override
    public synchronized void run() {
        try {
            count--;
            // 使用 sleep 模拟计算机可能会出现的各种情况
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程-" + Thread.currentThread().getName() + " 计算，count=" + count);
    }
}
