package com.tazine.evo.async.method.callback;

/**
 * 回调接口
 *
 * @author frank
 * @date 2018/12/16
 */
public interface FetcherCallback {

    void onData(Data data)throws Exception;

    void onError(Throwable throwable);

}
