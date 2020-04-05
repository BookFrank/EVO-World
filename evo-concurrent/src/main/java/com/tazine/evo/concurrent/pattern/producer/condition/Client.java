package com.tazine.evo.concurrent.pattern.producer.condition;

/**
 * Client
 *
 * @author frank
 * @date 2018/1/28
 */
public class Client {

    public static void main(String[] args) {

        MyService service = new MyService();

        new ProducerThread(service).start();
        new ConsumerThread(service).start();

    }
}
