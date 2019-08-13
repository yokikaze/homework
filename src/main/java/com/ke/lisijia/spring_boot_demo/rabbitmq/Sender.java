package com.ke.lisijia.spring_boot_demo.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send( String message) {
        this.amqpTemplate.convertAndSend("topic", message);
    }
}
