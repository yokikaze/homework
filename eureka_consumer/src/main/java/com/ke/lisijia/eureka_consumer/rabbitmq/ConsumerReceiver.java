package com.ke.lisijia.eureka_consumer.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@Slf4j
@EnableBinding(value = ConsumerMessage.class)
public class ConsumerReceiver {

    @StreamListener(ConsumerMessage.INPUT)
    public void receiver(String message) {
        log.info("receive message: {}", message);
    }
}
