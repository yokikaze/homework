package com.ke.lisijia.spring_boot_demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

//@Component
@Slf4j
public class SinkMessageListener implements CommandLineRunner {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(id = "test-consumer", topics = {"realtime.analytics_h5_source"})
    public void listen(ConsumerRecord<String, String> cr) throws Exception {
        log.debug(Thread.currentThread().getName() + " {}", cr.value());
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("start producer 10000 message ");
        for (int i = 0; i < 100 ;i++) {
            kafkaTemplate.send("realtime.analytics_h5_source",
                    UUID.randomUUID().toString(), "i" + i);
        }
    }
}
