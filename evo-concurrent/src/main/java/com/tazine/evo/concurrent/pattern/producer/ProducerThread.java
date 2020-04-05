package com.tazine.evo.concurrent.pattern.producer;

/**
 * ProducerThread
 *
 * @author frank
 * @date 2018/1/28
 */
public class ProducerThread extends Thread {

    private Producer producer;

    public ProducerThread(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                producer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
