package com.ke.lisijia.spring_boot_demo.web.controller;

import com.ke.lisijia.spring_boot_demo.model.Student;
import com.ke.lisijia.spring_boot_demo.service.MybatisService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



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

    @RequestMapping(value = "/insertStudent",method = RequestMethod.POST)
    @ResponseBody
    public Student insertStudent(@RequestBody String jsonStudent){
        return mybatisService.insertStudent(jsonStudent);
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
    @ResponseBody
    public String deleteStudent(@RequestBody String idString) {
        return mybatisService.deleteStudent(idString);
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(){
        return mybatisService.updateStudent();
    }

    @RequestMapping("/updateStudentGender")
    @ResponseBody
    public Student updateStudentGender(@RequestBody String gender) {
        return mybatisService.updateStudentGender(gender);
    }

    @RequestMapping("/updateName/id={id}&name={name}")
    public String updateName(@PathVariable(value = "id") int id ,
                             @PathVariable(value = "name") String name){
        return mybatisService.updateName(id, name);
    }

    @RequestMapping("/findByName/{name}")
    @ResponseBody
    public String findByName(@PathVariable(value = "name") String name) {
        return mybatisService.findByName(name);
    }
}
