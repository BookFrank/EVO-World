package com.tazine.evo.async.thread.create;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * TicketHolder
 *
 * @author frank
 * @date 2019/08/25
 */
public class TicketHolder {

    private AtomicInteger ticketNum = new AtomicInteger(5);

    public AtomicInteger getTicketNum() {
        return ticketNum;
    }
}
