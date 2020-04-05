package com.tazine.evo.concurrent.pattern.producer;

import java.util.ArrayList;
import java.util.List;

/**
 * Client
 *
 * @author frank
 * @date 2018/1/28
 */
public class Client {

    public static void main(String[] args) {

        Object obj = new Object();

        List<Integer> list = new ArrayList<>();

        Producer producer = new Producer(obj, list);
        Consumer consumer = new Consumer(obj, list);

        new ProducerThread(producer).start();
        new ConsumerThread(consumer).start();

    }
}
