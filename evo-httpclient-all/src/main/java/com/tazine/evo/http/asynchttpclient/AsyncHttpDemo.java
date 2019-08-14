package com.tazine.evo.http.asynchttpclient;

import io.netty.handler.codec.http.HttpHeaders;
import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * AsyncHttpDemo
 *
 * @author frank
 * @date 2019/08/13
 */
public class AsyncHttpDemo {

    public static void main(String[] args) {

        //syncRequest();

        asyncRequest();

    }

    /**
     * 异步 HTTP 请求，main 线程发起的请求但是是 AsyncHttpClient 处理的 Response
     */
    private static void asyncRequest(){
        String url = "https://www.baidu.com/home/msg/data/personalcontent";
        AsyncHttpClient c = new DefaultAsyncHttpClient();
        Future<Response> f = c.prepareGet(url).execute(new AsyncCompletionHandler<Response>() {
            // onCompleted method will be invoked once the http response has been fully read.
            // 一旦完全读取Http响应，就调用onCompleted方法

            // Response object includes the http headers and the response body.
            // Response 对象包括HTTP请求头和响应体
            @Override
            public Response onCompleted(Response response) throws Exception {
                System.out.println(Thread.currentThread().getName() + " - " + "完成请求");
                System.out.println(Thread.currentThread().getName() + " - " + response.getResponseBody());
                return response;
            }

            @Override
            public void onThrowable(Throwable t) {
                System.out.println("出现异常");
                super.onThrowable(t);
            }
        });

        try {
            Response response = f.get();
            System.out.println(Thread.currentThread().getName() + " - " + response.getResponseBody());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    /**
     * 同步HTTP请求
     */
    private static void syncRequest() {
        String url = "http://www.baidu.com";
        AsyncHttpClient c = new DefaultAsyncHttpClient();
        Future<Response> f = c.prepareGet(url).execute();

        try {
            HttpHeaders headers = f.get().getHeaders();
            headers.entries().stream().forEach(v -> {
                System.out.println(v.getKey() + ":" + v.getValue());
            });
            System.out.println(f.get().getResponseBody());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
