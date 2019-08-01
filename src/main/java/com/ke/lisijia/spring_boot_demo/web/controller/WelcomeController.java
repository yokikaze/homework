package com.ke.lisijia.spring_boot_demo.web.controller;

import com.ke.lisijia.spring_boot_demo.model.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/welcome")
public class WelcomeController {

    @Value("${thisProject.name}")
    private String thisProject;

    @Autowired
    ConfigBean configBean;

    @RequestMapping("")
    public String welcome(){
        System.out.println(configBean.toString());
        return "welcome to " + thisProject;
    }


    @RequestMapping("/{name}")
    public String welcome(@PathVariable(value = "name") String name) {
        return "welcome " + name;
    }
}
