package com.ke.lisijia.eureka_client.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;


    @GetMapping("/serviceList")
    public String dc() {
        String services = "services:" + discoveryClient.getServices();
        log.info("{}", services);
        return services;
    }

    @GetMapping("/service")
    public String service() {
        return "this is client's service";
    }

}
