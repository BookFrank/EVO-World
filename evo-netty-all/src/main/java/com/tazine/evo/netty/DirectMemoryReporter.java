package com.tazine.evo.netty;

import io.netty.util.internal.PlatformDependent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Gateway堆外内存日志
 *
 * @author frank
 * @date 2019/01/04
 */
@Component
@Configuration
@EnableScheduling
@Slf4j(topic = "GatewayMemoryLog")
public class DirectMemoryReporter {

    private static final int _1k = 1024;

    private AtomicLong directMemory;

    @PostConstruct
    public void init(){
        Field field = ReflectionUtils.findField(PlatformDependent.class, "DIRECT_MEMORY_COUNTER");
        field.setAccessible(true);

        try {
            directMemory = (AtomicLong)field.get(PlatformDependent.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void report(){
        System.out.println("[DIRECT_MOMORY] 当前堆外内存 " + directMemory.get()/_1k + " K");
        log.info("[DIRECT_MOMORY] 当前堆外内存 {} K", directMemory.get()/_1k);
    }
}
