package com.ke.lisijia.spring_boot_demo.web.controller;

import com.ke.lisijia.spring_boot_demo.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisController {

    @Autowired
    MybatisService mybatisService;

    @RequestMapping("/findAll")
    public String findAll() {
        return mybatisService.findAll();
    }

    @RequestMapping("/findById/{id}")
    public String findById(@PathVariable(value = "id")int id) {
        return mybatisService.findById(id);
    }

    @RequestMapping("/insertStudent")
    public String insertStudent(){
        return mybatisService.insertStudent();
    }

    @RequestMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id")int id) {
        return mybatisService.deleteStudent(id);
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(){
        return mybatisService.updateStudent();
    }
}
