package com.ke.lisijia.eureka_consumer_feign.controller;

import com.ke.lisijia.eureka_consumer_feign.feign.EurekaClient;
import com.ke.lisijia.eureka_consumer_feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private FeignService feignService;

    @GetMapping("/service")
    public String service() {
        return eurekaClient.service();
    }

    @GetMapping("/list")
    public String list() {
        return eurekaClient.serviceList();
    }

    @GetMapping("/fallback")
    public String serviceFallback() {
        return feignService.serviceFallback();
    }
}
