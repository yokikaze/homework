package com.ke.lisijia.spring_boot_demo.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

@Data
@Component
@Document(collection = "studentsTest")
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
    @NotBlank(message = "姓名不能为空")
    @Length(message = "姓名应在2-5个汉字", min = 2, max = 5)
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
