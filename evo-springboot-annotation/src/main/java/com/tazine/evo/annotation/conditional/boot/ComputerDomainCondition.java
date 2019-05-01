package com.tazine.evo.annotation.conditional.boot;

import com.google.common.base.Splitter;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

/**
 * ComputerDomainCondition
 *
 * @author frank
 * @date 2019/05/01
 */
public class ComputerDomainCondition extends SpringBootCondition {

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ComputerDomain.class.getName());
        Object domain = annotationAttributes.get("domain");
        System.err.println((String) domain);
        if (domain == null){
            return new ConditionOutcome(false, "error");
        }

        // 获取environment中的值
        //String key1 = context.getEnvironment().getProperty(key.toString());
        //if (value.equals(key1)) {
        //    //如果environment中的值与指定的value一致，则返回true
        //    return new ConditionOutcome(true, "ok");
        //}

        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            String name = InetAddress.getLocalHost().getHostName();
            List<String> nameList = Splitter.on(".").splitToList(name);
            if (nameList.get(nameList.size() - 1).equalsIgnoreCase((String)domain)){
                return new ConditionOutcome(true, "ok");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return new ConditionOutcome(false, "error");
    }

    public static void main(String[] args) throws UnknownHostException {
        String name = InetAddress.getLocalHost().getHostName();
        System.out.println(name);
    }
}
