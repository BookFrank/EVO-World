package com.tazine.evo.boot2.filter.conf;

import com.tazine.evo.boot2.filter.ManualConfFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * EvoFilterConfig
 *
 * @author jiaer.ly
 * @date 2019/11/12
 */
@Configuration
public class EvoFilterConfig {

    @Bean
    public FilterRegistrationBean<ManualConfFilter> responseFilter() {
        FilterRegistrationBean<ManualConfFilter> registration = new FilterRegistrationBean<ManualConfFilter>();
        registration.setFilter(manualConfFilter());
        registration.addUrlPatterns("/*");
        //registration.setOrder(2);
        //registration.setName("manualConfFilter");
        registration.setName("B");
        return registration;
    }

    @Bean
    public ManualConfFilter manualConfFilter() {
        return new ManualConfFilter();
    }
}
