package com.ke.lisijia.eureka_consumer_ribbon.controller;

import com.ke.lisijia.eureka_consumer_ribbon.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/ribbon")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/consumer")
    public String consumer() {
        return restTemplate.getForObject("http://eureka-client/serviceList", String.class);
    }

    @GetMapping("/port")
    public String port() {
        return restTemplate.getForObject("http://eureka-client/service", String.class);
    }

    @GetMapping("/fallback")
    public String fallback(){
        return consumerService.fallbackService();
    }
}
