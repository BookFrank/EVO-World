package com.tazine.evo.concurrent.pattern.producer;

/**
 * ConsumerThread
 *
 * @author frank
 * @date 2018/1/28
 */
public class ConsumerThread extends Thread {

    private Consumer consumer;

    public ConsumerThread(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true){
            try {
                consumer.consume();
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
