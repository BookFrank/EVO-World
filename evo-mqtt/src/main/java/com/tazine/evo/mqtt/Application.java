package com.tazine.evo.mqtt;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

/**
 * SpringBoot2.0 实践
 *
 * @author frank
 * @date 2018/11/11
 */
@SpringBootApplication
@EnableConfigurationProperties({MqttProperties.class})
public class Application {

    @Autowired
    private MqttProperties mqttProperties;

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(Application.class)
            //.profiles("dev")
            .run(args);

        System.err.println(JSON.toJSONString(context.getEnvironment()));
    }

    @PostConstruct
    public void init(){
        System.err.println(JSON.toJSONString(mqttProperties));
    }
}
