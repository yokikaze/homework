package com.ke.lisijia.eureka_client.rabbitmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

/**
 * 通道接口
 */
public interface ClientMessage {

    String OUTPUT = "Consumer-message";

    @Output(value = OUTPUT)
    SubscribableChannel getOutput();

}
