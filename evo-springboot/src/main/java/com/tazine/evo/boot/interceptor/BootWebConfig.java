package com.tazine.evo.boot.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author jiaer.ly
 * @date 2018/11/07
 */
@Configuration
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
