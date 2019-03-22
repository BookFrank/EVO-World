package com.tazine.evo.http.asynchttpclient;

import io.netty.handler.codec.http.HttpHeaders;
import org.asynchttpclient.*;

import java.nio.charset.Charset;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * OfficialAsyncHttpTest
 *
 * @author frank
 * @date 2019/03/21
 */
public class OfficialAsyncHttpTest {

    private static AsyncHttpClientConfig buildAsyncHttpClientConfig() {
        return new DefaultAsyncHttpClientConfig.Builder()
            .setConnectTimeout(200)
            .setRequestTimeout(200)
            .setReadTimeout(200)
            .setConnectionTtl(500)
            .setPooledConnectionIdleTimeout(500)
            .setMaxConnections(20000)
            .setMaxConnectionsPerHost(10000)
            .build();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Starting Client init");
        try (DefaultAsyncHttpClient httpClient = new DefaultAsyncHttpClient(buildAsyncHttpClientConfig());) {
            System.out.println("Client init Complete!");

            //shows leak
            threadPoolExec(httpClient);

            //no leak
            //manualThreads(httpClient);
        }
    }

    private static void threadPoolExec(DefaultAsyncHttpClient httpClient) throws InterruptedException {
        System.out.println("Thread Pool");
        ThreadPoolExecutor exec = new ThreadPoolExecutor(10, 10, 500, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(200));
        while (true) {
            Thread.sleep(10);
            System.out.println("提交任务");
            exec.execute(() -> {
                Future<Response> result = httpClient.executeRequest(prepareRequest(),
                    new AsyncCompletionHandler<Response>() {
                        @Override
                        public Response onCompleted(Response response) throws Exception {
                            System.out.println("请求成功" + response.getResponseBody());
                            return response;
                        }
                    });
                try {
                    result.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void manualThreads(DefaultAsyncHttpClient httpClient) {
        System.out.println("ManualThreads");
        for (int j = 0; j < 10; j++) {
            final int q = j;
            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        Future<Response> result = httpClient.executeRequest(prepareRequest(),
                            new AsyncCompletionHandler<Response>() {
                                @Override
                                public Response onCompleted(Response response) throws Exception {
                                    return null;
                                }
                            });
                        result.get();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.setDaemon(true);
            thread.start();
        }

        while (true) {}
    }

    private static final String JSON = "{\"adCodes\":[110000],\"startTime\":15282144001,\"endTime\":1548732800,"
        + "\"order\":1,\"pageNum\":1,\"pageSize\":5,\"queryList\":[{\"congestRate\":0.02,\"congestType\":1,"
        + "\"distance\":800,\"duration\":4,\"roadType\":0},{\"congestRate\":0.02,\"congestType\":1,\"distance\":700,"
        + "\"duration\":4,\"roadType\":1},{\"congestRate\":0.02,\"congestType\":1,\"distance\":700,\"duration\":4,"
        + "\"roadType\":2},{\"congestRate\":0.02,\"congestType\":1,\"distance\":700,\"duration\":4,\"roadType\":3},"
        + "{\"congestRate\":0.02,\"congestType\":1,\"distance\":700,\"duration\":4,\"roadType\":4},"
        + "{\"congestRate\":0.02,\"congestType\":1,\"distance\":700,\"duration\":4,\"roadType\":5},"
        + "{\"congestRate\":0.02,\"congestType\":1,\"distance\":700,\"duration\":4,\"roadType\":6},"
        + "{\"congestRate\":0.02,\"congestType\":1,\"distance\":700,\"duration\":4,\"roadType\":7},"
        + "{\"congestRate\":0.02,\"congestType\":1,\"distance\":1300,\"duration\":4,\"roadType\":8},"
        + "{\"congestRate\":0.02,\"congestType\":1,\"distance\":700,\"duration\":4,\"roadType\":9}]}";

    protected static Request prepareRequest() {
        return new RequestBuilder()
            .setMethod("POST")
            .setUrl("http://www.baidu.com")
            .setBody(JSON.getBytes())
            .setCharset(Charset.forName("UTF-8"))
            .setHeader(HttpHeaders.Names.CONTENT_TYPE, "application/json")
            .build();
    }
}
