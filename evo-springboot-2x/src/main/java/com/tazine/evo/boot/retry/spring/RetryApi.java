package com.tazine.evo.boot.retry.spring;

import org.springframework.stereotype.Component;

/**
 * RetryApi-模拟外部调用API
 *
 * @author frank
 * @date 2019/03/04
 */
@Component
public class RetryApi {

    public String getHttpResult() {
        System.out.println("发送 HTTP 请求");
        return null;
    }

}
