package com.ke.lisijia.eureka_consumer_feign.feign;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.cloud.netflix.feign.FeignClient("eureka-client")
public interface EurekaClient {

    @GetMapping("/service")
    public String service();

    @GetMapping("/serviceList")
    public String serviceList();
}
