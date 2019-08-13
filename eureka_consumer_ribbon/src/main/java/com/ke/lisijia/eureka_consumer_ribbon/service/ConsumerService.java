package com.ke.lisijia.eureka_consumer_ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    public String fallbackService() {
        return restTemplate.getForObject("http://eureka-client/fallback", String.class);
    }

    public String fallback() {
        return "service fallback";
    }
}
