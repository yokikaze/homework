package com.ke.lisijia.spring_boot_demo.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

@Data
@Component
@Alias("student")
public class Student {
    /**
     * 主键
     */
    @Id
    private int id;

    /**
     * 姓名
     */
    @Field("name")
    private String name;

    /**
     * 性别
     */
    @Field("gender")
    private String gender;

    /**
     * 年级
     */
    @Field("grade")
    private int grade;

    /**
     * 班级
     */
    @Field("classroom")
    private int classroom;

    /**
     * 分数
     */
    @Field("score")
    private int score;
}
