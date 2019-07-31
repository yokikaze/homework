package com.ke.lisijia.spring_boot_demo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Data
@Service
@ConfigurationProperties(prefix = "thisProject")
public class ConfigBean {
    private String name;
    private int vision;
}
