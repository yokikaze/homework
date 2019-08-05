package com.ke.lisijia.spring_boot_demo.util;

import com.ke.lisijia.spring_boot_demo.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class BusinessExceptionHandler {

//    @InitBinder
//    public void initBinder(WebDataBinder webDataBinder) {
//        System.out.println("请求有参数");
//    }

    @ExceptionHandler(Exception.class)
    public Object handlerException(Exception e, HttpServletRequest request) {
        AjaxObject ajaxObject= new AjaxObject();
        if(e instanceof BusinessException) {
            ajaxObject.put("code", ((BusinessException) e).getCode());
            ajaxObject.put("message", ((BusinessException) e).getMsg());
        }else {
            ajaxObject.put("code", "500");
            ajaxObject.put("message", "未知错误，请联系管理员");
        }
        return ajaxObject;
    }
}
