package com.tazine.evo.mqtt.subscribe;

import com.tazine.evo.mqtt.MqttProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

/**
 * 订阅配置
 * @author frank
 * @date 2019/06/04
 */
@Slf4j
@Configuration
public class MqttInboundConfiguration {

    @Autowired
    private MqttProperties mqttProperties;

    @Bean
    public MessageProducer inbound(MqttPahoClientFactory mqttPahoClientFactory) {
        String[] inboundTopics = mqttProperties.getInbound().getTopics().split(",");
        MqttPahoMessageDrivenChannelAdapter adapter =
            new MqttPahoMessageDrivenChannelAdapter(mqttProperties.getInbound().getUrl(), mqttProperties.getInbound().getClientId(),
                mqttPahoClientFactory,inboundTopics);
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                //log.info("收到消息："+(String) message.getPayload());
                System.err.println("mqttInputChannel 收到消息" + (String) message.getPayload());
            }
        };
    }

    //@Bean
    //public MessageChannel mqttInputChannelTwo() {
    //    return new DirectChannel();
    //}
    //
    //@Bean
    //public MessageProducer inbound2(MqttPahoClientFactory mqttPahoClientFactory) {
    //    String[] inboundTopics = mqttProperties.getInbound().getTopics().split(",");
    //    MqttPahoMessageDrivenChannelAdapter adapter =
    //        new MqttPahoMessageDrivenChannelAdapter(mqttProperties.getInbound().getUrl(), mqttProperties.getInbound().getClientId(),
    //            mqttPahoClientFactory,inboundTopics);
    //    adapter.setCompletionTimeout(5000);
    //    adapter.setConverter(new DefaultPahoMessageConverter());
    //    adapter.setQos(1);
    //    adapter.setOutputChannel(mqttInputChannelTwo());
    //    return adapter;
    //}
    //
    //@Bean
    //@ServiceActivator(inputChannel = "mqttInputChannelTwo")
    //public MessageHandler handlerTwo() {
    //    return new MessageHandler() {
    //        @Override
    //        public void handleMessage(Message<?> message) throws MessagingException {
    //            //log.info("收到消息："+(String) message.getPayload());
    //            System.err.println(" mqttInputChannelTwo 收到消息" + (String) message.getPayload());
    //        }
    //    };
    //}
}
