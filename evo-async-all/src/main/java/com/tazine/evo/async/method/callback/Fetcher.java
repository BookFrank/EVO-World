package com.tazine.evo.async.method.callback;

import java.util.concurrent.TimeUnit;

/**
 * 数据获取任务
 *
 * @author frank
 * @date 2018/12/16
 */
public class Fetcher {

    final Data data;

    public Fetcher(Data data) {
        this.data = data;
    }

    public void fetchData(FetcherCallback callback) {
        try {
            System.out.println("正在进行数据获取，请等待......");
            TimeUnit.SECONDS.sleep(2);
            callback.onData(data);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

}
