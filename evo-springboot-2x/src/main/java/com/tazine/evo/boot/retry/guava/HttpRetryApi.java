package com.tazine.evo.boot.retry.guava;

import org.springframework.stereotype.Component;

/**
 * HttpRetryApi
 *
 * @author frank
 * @date 2019/03/06
 */
@Component
public class HttpRetryApi {

    public String getHttpResult() {


        System.out.println("发送 HTTP 请求");
        return null;
    }

    private static void test() {
        //Retryer<String> retryer = RetryerBuilder.newBuilder()
        //    .retryIfException()
        //.retryIfResult()

    }

    public static void main(String[] args) {


    }

}
