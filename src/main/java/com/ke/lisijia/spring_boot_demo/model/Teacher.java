package com.ke.lisijia.spring_boot_demo.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
public class Teacher {

    /**
     * 姓名
     */
    private String name;

    /**
     * 学科
     */
    private String subject;

}
