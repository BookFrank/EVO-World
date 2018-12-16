package com.tazine.evo.async.method.callback;

/**
 * Worker
 *
 * @author frank
 * @date 2018/12/16
 */
public class Worker {

    public void doWork() {
        Fetcher fetcher = new Fetcher(new Data());
        fetcher.fetchData(new FetcherCallback() {
            @Override
            public void onError(Throwable cause) {
                System.out.println("An error accour: " + cause.getMessage());
            }

            @Override
            public void onData(Data data) {
                System.out.println("Data received: " + data);
            }
        });
        System.out.println("程序执行完成");
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.doWork();
    }
}
