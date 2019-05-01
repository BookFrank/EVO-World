package com.tazine.evo.annotation.conditional.raw;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ShanghaiCondition
 *
 * @author frank
 * @date 2019/05/01
 */
public class ShanghaiCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        boolean match = false;
        try {
            // 通过 InetAddress 获取本机IP与计算机名
            String ip = InetAddress.getLocalHost().getHostAddress();
            String name = InetAddress.getLocalHost().getHostName();

            // 如果ip是上海的话
            if (!ip.contains("shanghai")){
                match = true;
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return match;
    }
}
