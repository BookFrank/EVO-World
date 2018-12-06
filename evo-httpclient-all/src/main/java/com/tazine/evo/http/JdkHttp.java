package com.tazine.evo.http;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * JdkHttp
 *
 * @author frank
 * @date 2018/12/05
 */
public class JdkHttp {

    public static void main(String[] args) {
        try {
            String fileUrl = "https://www.huxiu.com/article/274462.html";
            HttpURLConnection conn = (HttpURLConnection)new URL(fileUrl).openConnection();
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = conn.getInputStream();
                System.err.println(inputStream.available());
                // 读取stream 所有字节
                //byte[] bytes = IOUtils.toByteArray(inputStream);

                // 读取stream 所有String
                List<String> strings = IOUtils.readLines(inputStream, "utf-8");
                strings.forEach(line -> {
                    System.err.println(line);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
