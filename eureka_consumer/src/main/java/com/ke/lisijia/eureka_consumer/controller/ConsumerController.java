package com.ke.lisijia.eureka_consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class ConsumerController {

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String consumer() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        String cilentUrl = "http://" + serviceInstance.getHost() + ":" +serviceInstance.getPort() ;
        log.info(cilentUrl + "/serviceList");
        log.info(cilentUrl + "/service");
        return restTemplate.getForObject(cilentUrl+ "/serviceList", String.class) + "\n" +
                restTemplate.getForObject(cilentUrl + "/service", String.class);

    }
}
