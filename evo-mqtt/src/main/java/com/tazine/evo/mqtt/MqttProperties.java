package com.tazine.evo.mqtt;

import com.tazine.evo.mqtt.publish.MqttOutboundProperties;
import com.tazine.evo.mqtt.subscribe.MqttInboundProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author jiaer.ly
 * @date 2019/06/04
 */
@Data
@ConfigurationProperties(prefix = "com.mqtt")
public class MqttProperties {

    private MqttInboundProperties inbound;
    private MqttOutboundProperties outbound;
}
