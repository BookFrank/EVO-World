package com.tazine.evo.mqtt.subscribe;

import lombok.Data;

/**
 * MQTT订阅配置
 *
 * @author frank
 * @date 2019/06/04
 */
@Data
public class MqttInboundProperties {

    private String url;
    private String username;
    private String password;
    private String clientId;
    private String topics;
}
