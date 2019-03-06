package com.tazine.evo.boot.config.mvc;

import com.tazine.evo.boot.interceptor.EvoBootInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置方法一: SpringMvcConfig 配置
 *
 * @author frank
 * @date 2018/11/13
 */
@Configuration
public class SpringMvcConfig {

    @Autowired
    private EvoBootInterceptor evoBootInterceptor;

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // 添加拦截器
                registry.addInterceptor(evoBootInterceptor);
            }
        };
    }
}
