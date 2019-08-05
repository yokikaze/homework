package com.ke.lisijia.spring_boot_demo.web.controller;

import com.ke.lisijia.spring_boot_demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisController {

    @Autowired
    RedisService redisService;

    @GetMapping("/redis/key={key}&value={value}")
    @ResponseBody
    public String redisInsert(@PathVariable(value = "key") String key,
                              @PathVariable(value = "value") String value) {
        return redisService.insert(key, value);
    }

    @GetMapping("redis/get={key}")
    @ResponseBody
    public String redisGet(@PathVariable(value = "key") String key) {
        return redisService.get(key);
    }
}
