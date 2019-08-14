package com.ke.lisijia.eureka_client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class SleuthController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/after")
    public String afterTime(HttpServletRequest request) {
        String result = restTemplate.getForObject("http://eureka-client-after/time", String.class);
        log.info("<using eureka-client>  TraceId:{} , SpanId:{} , ParentSpanId:{} , Sampled:{} , Name:{}",
                request.getHeader("X-B3-TraceId"),
                request.getHeader("X-B3-SpanId"),
                request.getHeader("X-B3-ParentSpanId"),
                request.getHeader("X-B3-Sampled"),
                request.getHeader("X-Span-Name"));
        return result;
    }
}
