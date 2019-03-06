package com.tazine.evo.boot.config.mvc;

import com.tazine.evo.boot.interceptor.EvoBootInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置方法一: SpringMvcConfig 配置
 *
 * @author frank
 * @date 2018/11/07
 */
//@Configuration
public class BootWebConfig implements WebMvcConfigurer {

    private final EvoBootInterceptor evoBootInterceptor;

    @Autowired
    public BootWebConfig(EvoBootInterceptor evoBootInterceptor) {this.evoBootInterceptor = evoBootInterceptor;}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(evoBootInterceptor)
            .addPathPatterns("/*");
    }

}
