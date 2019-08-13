package com.ke.lisijia.eureka_consumer_feign.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class StartRunner implements CommandLineRunner{

    @Override
    public void run(String... args)throws Exception{
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>consumer-feign已成功启动<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

}
