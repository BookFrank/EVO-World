package com.tazine.evo.async.method.callback;

/**
 * Created by lina on 2018/12/16.
 *
 * @author frank
 * @since 1.0.0
 */
public class Fetcher {

    final Data data;

    public Fetcher(Data data) {
        this.data = data;
    }

    public void fetchData(FetcherCallback callback) {
        try {
            callback.onData(data);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

}
