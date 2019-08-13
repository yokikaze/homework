package com.ke.lisijia.spring_boot_demo.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues = "topic")
public class Receiver {

    @RabbitHandler
    public void process(String message) {
        log.info("Receiver:{}", message);
    }
}
