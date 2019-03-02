package com.tazine.evo.http.okhttp;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OkHttpConfig
 *
 * @author frank
 * @date 2018/03/02
 */
@Configuration
public class OkHttpConfig {

    @Bean
    public OkHttpClient okHttpClient(){
        OkHttpClient httpClient = new OkHttpClient();
        // 设置连接超时
    }

}
