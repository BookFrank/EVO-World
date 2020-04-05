package com.tazine.evo.concurrent.pattern.producer.condition;

/**
 * ConsumerThread
 *
 * @author frank
 * @date 2018/1/28
 */
public class ConsumerThread extends Thread {

    private MyService service;

    public ConsumerThread(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        while (true){
            try {
                service.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
