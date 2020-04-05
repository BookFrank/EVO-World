package com.tazine.evo.concurrent.pattern.producer.condition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * MyService
 *
 * @author frank
 * @date 2018/1/28
 */
public class MyService {

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private List<Integer> list = new ArrayList<>();

    private boolean hasValue = false;


    public void produce() throws InterruptedException {
        lock.lock();

        try {
            while (list.size() >= 3){
                condition.await();
            }
            int i = new Random().nextInt();
            System.out.println("生产者生产 -- " + i);
            list.add(i);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        lock.lock();
        try {
            while (list.isEmpty()){
                condition.await();
            }
            int i = list.get(0);
            System.out.println("消费者消费 -- " + i);
            list.remove(0);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
