package com.ke.lisijia.spring_boot_demo.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class BusinessException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String msg;

    @Getter
    @Setter
    private int code = 500;

    public BusinessException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BusinessException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BusinessException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }
}
