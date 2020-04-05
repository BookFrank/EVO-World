package com.tazine.evo.concurrent.pattern.producer.block;

import java.util.concurrent.BlockingQueue;

/**
 * ConsumerThread
 *
 * @author frank
 * @date 2018/1/28
 */
public class ConsumerThread extends Thread {

    private BlockingQueue<Integer> queue;

    public ConsumerThread(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            int i;
            try {
                i = queue.take();
                System.out.println("消费者消费 -- " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
