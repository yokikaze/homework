package com.ke.lisijia.spring_boot_demo.web.controller;

import com.ke.lisijia.spring_boot_demo.exception.BusinessException;
import com.ke.lisijia.spring_boot_demo.model.ConfigBean;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping("/json")
    public void jsonApi(ModelMap modelMap) {
        System.out.println("author");
        throw new BusinessException(900,"指定异常");
    }
}
