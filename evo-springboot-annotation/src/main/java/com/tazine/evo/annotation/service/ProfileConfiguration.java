package com.tazine.evo.annotation.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * ProfileConfiguration
 *
 * @author frank
 * @date 2018/09/19
 */
@Configuration
public class ProfileConfiguration {

    /**
     * 直接使用 Java Config 不加 @Profile，会被实例化
     *
     * @return ProfileService
     */
    @Bean
    public ProfileService profileService() {
        return new ProfileService("Basic ProfileService");
    }

    /**
     * 会根据当前 profile 环境决定是否实例化
     *
     * @return ProfileService
     */
    @Bean
    @Profile("dev")
    public ProfileService devProfileService() {
        return new ProfileService("Dev ProfileService");
    }

    @Bean
    @Profile("prod")
    public ProfileService prodProfileService() {
        return new ProfileService("Prod ProfileService");
    }

}
