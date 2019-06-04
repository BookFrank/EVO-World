package com.tazine.evo.mqtt.publish;

import lombok.Data;

/**
 * MQTT发布配置
 *
 * @author frank
 * @date 2019/06/04
 */
@Data
public class MqttOutboundProperties {

    private String urls;
    private String username;
    private String password;
    private String clientId;
    private String topic;
}
