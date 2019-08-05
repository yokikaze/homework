package com.ke.lisijia.spring_boot_demo.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ke.lisijia.spring_boot_demo.model.Student;
import com.ke.lisijia.spring_boot_demo.service.MongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MongoDBController {

    @Autowired
    MongoDBService mongoDBService;

    @RequestMapping("/mongo/findAll")
    @ResponseBody
    public String findAll() {
        return JSON.toJSONString(mongoDBService.findAll());
    }

    @RequestMapping("/mongo/insert")
    @ResponseBody
    public String insertStudent(@RequestBody Student student) {
        return JSON.toJSONString(mongoDBService.insertStudent(student));
    }

    @RequestMapping("/mongo/update")
    @ResponseBody
    public String updateStudent(@RequestBody Student student) {
        return JSON.toJSONString(mongoDBService.updateStudent(student));
    }
}
