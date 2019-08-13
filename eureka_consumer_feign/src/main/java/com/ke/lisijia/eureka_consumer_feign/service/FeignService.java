package com.ke.lisijia.eureka_consumer_feign.service;

import com.ke.lisijia.eureka_consumer_feign.feign.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeignService {

    @Autowired
    private EurekaClient eurekaClient;

    @HystrixCommand(fallbackMethod = "fallback")
    public String serviceFallback() {
        return eurekaClient.service();
    }

    public String fallback(){
        return "Service fallback";
    }
}
