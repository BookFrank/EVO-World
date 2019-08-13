package com.tazine.evo.http.jdk;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * 原生JDK进行HTTP请求
 *
 * @author frank
 * @date 2018/12/05
 */
public class JdkHttp {

    public static void main(String[] args) {
        String addr = "https://www.huxiu.com/article/274462.html";
        get(addr);
    }

    private static void postJson(String addr, String json){
        StringBuffer sbf = new StringBuffer();
        try {
            URL url = new URL(addr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.addRequestProperty("role", "Admin");
            connection.addRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            connection.connect();
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            if (!"".equals(json)) {
                out.writeBytes(json);
            }
            out.flush();
            out.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lines;
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sbf.append(lines);
            }
            System.out.println(sbf);
            reader.close();
            // 断开连接
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void get1(){
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

    /**
     * Get
     * @param addr URL
     */
    private static void get(String addr){
        try {
            // 1. 根据地址创建一个 java.net.URL 对象
            URL url = new URL(addr);

            // 2. 从 URL 对象中 openConnection 获得一个 HttpURLConnection
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.addRequestProperty("role", "admin");
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");

            // 3. 从 conn 中读取响应
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = conn.getInputStream();
                System.err.println(inputStream.available());
                // 原生读取
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String lines;
                while ((lines = reader.readLine()) != null) {
                    lines = new String(lines.getBytes(), "utf-8");
                    System.out.println(lines);
                }

                // 读取stream 所有字节
                //byte[] bytes = IOUtils.toByteArray(inputStream);

                // 读取stream 所有String
                //List<String> strings = IOUtils.readLines(inputStream, "utf-8");
                //strings.forEach(line -> {
                //    System.err.println(line);
                //});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
