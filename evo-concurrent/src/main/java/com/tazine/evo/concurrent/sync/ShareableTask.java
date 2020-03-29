package com.tazine.evo.concurrent.sync;

/**
 * 共享变量（共享资源）的线程
 *
 * @author jiaer.ly
 * @date 2020/03/29
 */
public class ShareableTask implements Runnable {

    private Integer count;

    public ShareableTask(Integer count) {
        this.count = count;
    }

    @Override
    public void run() {
        try {
            // 使用 sleep 模拟计算机可能会出现的各种情况
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count--;
        System.out.println("线程-" + Thread.currentThread().getName() + " 计算，count=" + count);

    }
}
