package com.tazine.evo.http.commonshttp;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author frank
 * @date 2019/08/05
 */
public class CommonsHttpClientTest {

    @Test
    public void test() throws IOException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100, 0, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>());

        for (int i = 0; i < 10000000; i++) {
            executor.submit(new Thread(() -> doGetAsString("http://www.baidu.com")));
        }

        //for (int i=0; i<100000; i++){
        //    doGetAsString("http://www.baidu.com");
        //}
        for (;;);
    }

    public String doGetAsString(String url){
        GetMethod getMethod = null;
        String is = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader br = null;
        try {
            HttpClient httpclient = new HttpClient();//问题标记①
            getMethod = new GetMethod(url);
            httpclient.executeMethod(getMethod);

            if (HttpStatus.SC_OK == getMethod.getStatusCode()) {
                //对返回结果进行消费，代码省略
                //System.out.println(new String(getMethod.getResponseBody()));
                Thread.sleep(200);
            }
            return is;
        } catch (Exception e) {
            if (getMethod != null) {
                getMethod.releaseConnection();  //问题标记②
            }
        } finally {
            //try {
                //inputStreamReader.close();
                //br.close();
            //} catch (IOException e) {
            //    e.printStackTrace();
            //}
        }
        return null;
    }
}
