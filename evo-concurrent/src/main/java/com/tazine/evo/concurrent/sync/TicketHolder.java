package com.tazine.evo.concurrent.sync;

/**
 * TicketHolder
 *
 * @author jiaer.ly
 * @date 2020/03/29
 */
public class TicketHolder {

    private Integer count;

    public TicketHolder(Integer count) {
        this.count = count;
    }

    //public void decr() {
    public synchronized void decr() {
        this.count--;
        System.out.println("线程-" + Thread.currentThread().getName() + " 计算，count=" + this.count);
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
