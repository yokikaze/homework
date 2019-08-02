package com.ke.lisijia.spring_boot_demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.Map;

public class AjaxObject extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public AjaxObject() {
        put("code", 0);
    }

    public static AjaxObject error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }

    public static AjaxObject error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static AjaxObject error(int code, String msg) {
        AjaxObject ajaxObject =new AjaxObject();
        ajaxObject.put("code", code);
        ajaxObject.put("message", msg);
        return ajaxObject;
    }

    public static AjaxObject ok(String msg) {
        AjaxObject ajaxObject = new AjaxObject();
        ajaxObject.put("message", msg);
        return ajaxObject;
    }

    public static AjaxObject ok(Map<String, Object> map) {
        AjaxObject ajaxObject = new AjaxObject();
        ajaxObject.putAll(map);
        return ajaxObject;
    }

    public AjaxObject put(String key,Object value) {
        super.put(key, value);
        return this;
    }

    public AjaxObject data(Object value) {
        super.put("data", value);
        return this;
    }

    public static AjaxObject apiError(String msg) {
        return error(1,msg);
    }
}
