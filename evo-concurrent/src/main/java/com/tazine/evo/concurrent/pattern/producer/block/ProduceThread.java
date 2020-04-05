package com.tazine.evo.concurrent.pattern.producer.block;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * ProduceThread
 *
 * @author frank
 * @date 2018/1/28
 */
public class ProduceThread extends Thread {

    private BlockingQueue<Integer> queue;

    public ProduceThread(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            int i = new Random().nextInt();
            if (queue.offer(i)){
                System.out.println("生产者生产 -- " + i);
            }else {
                System.out.println("加入队列失败");
            }
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
