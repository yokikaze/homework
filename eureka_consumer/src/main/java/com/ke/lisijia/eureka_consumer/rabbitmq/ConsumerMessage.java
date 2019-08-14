package com.ke.lisijia.eureka_consumer.rabbitmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerMessage {
    String INPUT = "pipeline";

    @Input(value = INPUT)
    SubscribableChannel getInput();
}
