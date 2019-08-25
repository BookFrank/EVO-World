package com.tazine.evo.async.thread.create;

/**
 * extends Thread 创建线程
 *
 * @author frank
 * @date 2019/08/25
 */
public class ThreadDemo extends Thread {

    private TicketHolder ticketHolder;

    public ThreadDemo(TicketHolder ticketHolder) {
        this.ticketHolder = ticketHolder;
    }

    @Override
    public void run() {
        String threadName = this.getName();
        if (ticketHolder.getTicketNum().decrementAndGet() >= 0) {
            System.out.println(this.getName() + ": get 1 ticket");
        }else {
            System.out.println(this.getName() + ": no ticket " + ticketHolder.getTicketNum().get());
        }
    }
}
