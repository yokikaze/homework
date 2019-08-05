package com.ke.lisijia.spring_boot_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    public String insert(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return "key="+key+"  value=" + get(key);
    }

    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
