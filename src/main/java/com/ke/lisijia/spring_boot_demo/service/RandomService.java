package com.ke.lisijia.spring_boot_demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ke.lisijia.spring_boot_demo.model.Teacher;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RandomService {

    @Autowired
    Teacher teacher;

    /**
     * JSON 转化Demo
     * @return
     */

    public String randomTeacher(){
        teacher.setName(RandomStringUtils.randomAlphabetic(2));
        teacher.setSubject(RandomStringUtils.randomAlphabetic(5));

        //bean 转为JSON字符串
        String JSONString = JSON.toJSONString(teacher);

        //JSON字符串转为bean
        Teacher randomTeacher = JSON.parseObject(JSONString, new TypeReference<Teacher>() {});
        //JSON字符串转为Bean（反射方式）
        Teacher random = JSON.parseObject(JSONString, Teacher.class);

        //JSON字符串转JSON对象
        JSONObject jsonObject = JSON.parseObject(JSONString);

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacher);
        teacherList.add(random);
        teacherList.add(randomTeacher);
        //JavaBean-list转JSON字符串数组
        String JSONListString = JSON.toJSONString(teacherList);
        //JSON字符串数组转JSONArray
        JSONArray jsonArray = JSON.parseArray(JSONListString);
        //JSON字符串转JavaBean-List
        List<Teacher> list = JSON.parseArray(JSONListString, Teacher.class);
        //JSONArray转JavaBean-List
        list = jsonArray.toJavaList(Teacher.class);
        return JSONString;
    }
}
