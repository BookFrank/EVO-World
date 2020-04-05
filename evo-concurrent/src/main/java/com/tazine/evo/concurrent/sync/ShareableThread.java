package com.tazine.evo.concurrent.sync;

/**
 * @author jiaer.ly
 * @date 2020/03/29
 */
public class ShareableThread extends Thread{

    private TicketHolder count;

    public ShareableThread(TicketHolder count, String name) {
        this.count = count;
        this.setName(name);
    }

    @Override
    public void run() {
        try {
            // 使用 sleep 模拟计算机可能会出现的各种情况
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.decr();
        //System.out.println("线程-" + Thread.currentThread().getName() + " 计算，count=" + count.getCount());
    }
}
