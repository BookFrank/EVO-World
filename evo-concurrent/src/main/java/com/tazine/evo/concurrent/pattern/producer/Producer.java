package com.tazine.evo.concurrent.pattern.producer;

import java.util.List;
import java.util.Random;

/**
 * 生产者
 *
 * @author frank
 * @since 1.0.0
 */
public class Producer {

    /**
     * 使用这个对象的 monitor 完成生产者和消费者之间的调度
     */
    private Object object;

    /**
     * 共享容器
     */
    private List<Integer> list;

    public Producer(Object object, List<Integer> list) {
        this.object = object;
        this.list = list;
    }

    public void produce() throws InterruptedException {

        synchronized (object){

            while (!list.isEmpty()){
                object.wait();
            }
            int i = new Random().nextInt();
            System.out.println("生产者生产出 " + i);
            list.add(i);
            // 唤醒消费者线程
            object.notify();
        }
    }
}
