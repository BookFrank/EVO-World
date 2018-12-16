package com.tazine.evo.async.method.callback;

/**
 * Created by lina on 2018/12/16.
 *
 * @author frank
 * @since 1.0.0
 */
public interface FetcherCallback {

    void onData(Data data)throws Exception;

    void onError(Throwable throwable);

}
