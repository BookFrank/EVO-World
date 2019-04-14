package com.tazine.evo.boot;

import com.tazine.evo.boot.config.property.EvoProperties;
import com.tazine.evo.boot.config.property.MailInitProperties;
import com.tazine.evo.boot.config.property.MailProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;

/**
 * SpringBoot2.0 实践
 *
 * @author frank
 * @date 2018/11/11
 */
@EnableConfigurationProperties({EvoProperties.class, MailInitProperties.class})
@EnableRetry
@ServletComponentScan
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean("anotherMail")
    @ConfigurationProperties(prefix = "mail")
    public MailProperties anotherMailProperties(){
        return new MailProperties();
    }
}
