package com.ke.lisijia.eureka_client_after.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class SleuthController {

    @GetMapping("/time")
    public String time() {
        log.info("using eureka-client-after");
        Date date = new Date(System.currentTimeMillis());
        return date.toString();
    }
}
