package com.tazine.evo.concurrent.pattern.producer.condition;

/**
 * ProducerThread
 *
 * @author frank
 * @date 2018/1/28
 */
public class ProducerThread extends Thread {

    private MyService service;

    public ProducerThread(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        while (true){
            try {
                service.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
