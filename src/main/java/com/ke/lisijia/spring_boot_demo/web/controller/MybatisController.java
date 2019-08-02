package com.ke.lisijia.spring_boot_demo.web.controller;

import com.ke.lisijia.spring_boot_demo.model.Student;
import com.ke.lisijia.spring_boot_demo.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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

    @RequestMapping(value = "/vaild", method = RequestMethod.POST)

    public String updateValid(@RequestBody @Valid Student student,
                              BindingResult bindingResult){
        System.out.println("asd");
        if(bindingResult.hasErrors()){
            ObjectError error = bindingResult.getAllErrors().iterator().next();
            System.out.println(error);
            return error.toString();
        }
        return mybatisService.updateStudent(student);
    }
}
