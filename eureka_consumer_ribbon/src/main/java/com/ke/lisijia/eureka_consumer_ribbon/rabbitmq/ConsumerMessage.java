package com.ke.lisijia.eureka_consumer_ribbon.rabbitmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 通道接口
 */
public interface ConsumerMessage {

    String INPUT = "input";

    @Input(value = INPUT)
    SubscribableChannel getInput();

}
