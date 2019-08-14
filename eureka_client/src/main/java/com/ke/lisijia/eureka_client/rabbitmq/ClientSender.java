package com.ke.lisijia.eureka_client.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import javax.xml.crypto.Data;
import java.util.Date;


@EnableBinding(value = ClientMessage.class)
public class ClientSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String message) {
        this.amqpTemplate.convertAndSend(message);
    }

    @Bean
    @InboundChannelAdapter(value = ClientMessage.OUTPUT, poller = @Poller(fixedDelay = "5000"))
    public MessageSource<String> clientMessageSource() {
        Date instant = new Date(System.currentTimeMillis());
        return () -> new GenericMessage<>("{\"topic\":\"topic-A\", \"message\":\"" + instant.toString() + "\"}");
    }
}
