package com.tazine.evo.async.thread.create;

/**
 * ThreadCreateTest
 *
 * @author frank
 * @date 2019/08/25
 */
public class ThreadCreateTest {

    public static void main(String[] args) {
        // 使用 extends Thread 创建线程抢票
        TicketHolder ticketHolder = new TicketHolder();
        for (int i = 0; i < 10; i++) {
            new ThreadDemo(ticketHolder).start();
        }
        System.out.println();

        // 使用 implements Runnable 创建线程抢票
        TicketHolder ticketHolder2 = new TicketHolder();
        Runnable runnable = new RunableDemo(ticketHolder2);
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }
}
