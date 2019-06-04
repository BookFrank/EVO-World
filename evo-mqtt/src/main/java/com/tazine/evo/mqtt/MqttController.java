package com.tazine.evo.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author frank
 * @date 2019/06/04
 */
@RestController
public class MqttController {

    @Autowired
    MqttSenderGateway mqttGateway;

    @RequestMapping(value="/send")
    public String sendMsg(@RequestParam String message){
        mqttGateway.sendToMqtt("defualt-topic:"+message);
        return "success";
    }
}
