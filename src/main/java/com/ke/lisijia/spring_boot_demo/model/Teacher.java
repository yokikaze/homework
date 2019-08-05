package com.ke.lisijia.spring_boot_demo.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("teacher")
public class Teacher {

    /**
     * 姓名
     */
    @Length(min = 2, max = 10, message = "姓名长度需要在2-10之间")
    private String name;

    /**
     * 学科
     */
    private String subject;

}
