package com.ke.lisijia.eureka_consumer_ribbon.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@Slf4j
@EnableBinding(ConsumerMessage.class)
public class Receiver {

    @StreamListener(ConsumerMessage.INPUT)
    public void receiver(String jsonMessage) {
        log.info("Receive message: {}", jsonMessage);
    }
}
