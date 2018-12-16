package com.tazine.evo.async.method.future;

import java.util.concurrent.*;

/**
 * FutureDemo
 *
 * @author frank
 * @date 2018/12/16
 */
public class FutureDemo {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("i am task1");
            }
        };

        Callable<Integer> task2 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Integer(10);
            }
        };

        Future<?> f1 = executor.submit(task1);
        Future<Integer> f2 = executor.submit(task2);
        System.out.println("task1 is completed? " + f1.isDone());
        System.out.println("task2 is completed? " + f2.isDone());
        //waiting task1 completed
        while (f1.isDone()) {
            System.out.println("task1 completed.");
            break;
        }
        //waiting task2 completed
        while (f2.isDone()) {
            try {
                System.out.println("return value by task2: " + f2.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            break;
        }

    }
}
