package com.tazine.evo.async.thread.create;

/**
 * Created by lina on 2019-08-25.
 *
 * @author frank
 * @date 2019-08-25
 */
public class RunableDemo implements Runnable {

    private TicketHolder ticketHolder;

    public RunableDemo(TicketHolder ticketHolder) {
        this.ticketHolder = ticketHolder;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if (ticketHolder.getTicketNum().get() > 0 && ticketHolder.getTicketNum().decrementAndGet() >= 0) {
            System.out.println(threadName + ": get 1 ticket");
        } else {
            System.out.println(threadName + ": no ticket " + ticketHolder.getTicketNum().get());
        }
    }
}
