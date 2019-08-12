package com.ke.lisijia.eureka_consumer_ribbon.controller;

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
    RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String consumer() {
        return restTemplate.getForObject("http://localhost:1001/serviceList", String.class);
       // return restTemplate.getForObject("http://eureka-client/service", String.class);
    }
}
