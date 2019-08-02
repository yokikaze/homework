package com.ke.lisijia.spring_boot_demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionDemoController {

    @RequestMapping(value = "/divide0")
    @ResponseBody
    public String divide0() {
        int error = 8/0;
        return "error";
    }

    /**
     * 局部异常处理(限定本Controller类内部)
     * 除0异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String divide0Exception(Exception e) {
        if(e instanceof ArithmeticException) {
            return "发生了除0异常";
        }
        return "发生了其他异常";
    }
}
