package com.tazine.evo.http.okhttp;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * OkHttpDemo
 *
 * @author frank
 * @date 2019/08/13
 */
public class OkHttpDemo {

    public static void main(String[] args) throws IOException {

        // 1. 采用默认构造 builder 帮助建立一个默认 client
        OkHttpClient client = new OkHttpClient();

        // 2. 创建用于 HTTP 请求的 Request 对象
        Request request = new Request.Builder()
            .url("http://www.baidu.com")
            .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("服务器端错误：" + response);
        }

        Headers responseHeaders = response.headers();
        for (int i = 0; i < responseHeaders.size(); i++) {
            System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
        }

        System.out.println(response.body().string());
    }
}
