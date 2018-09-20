package com.tazine.evo.annotation.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author frank
 * @date 2018/09/19
 */
@Configuration
public class ProfileConfiguration {

    @Bean
    public ProfileService profileService(){
        return new ProfileService("Basic ProfileService");
    }

    @Bean
    @Profile("dev")
    public ProfileService devProfileService(){
        return new ProfileService("Dev ProfileService");
    }

    @Bean
    @Profile("prod")
    public ProfileService prodProfileService(){
        return new ProfileService("Prod ProfileService");
    }

}
