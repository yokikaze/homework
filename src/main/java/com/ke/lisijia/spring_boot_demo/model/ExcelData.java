package com.ke.lisijia.spring_boot_demo.model;

import lombok.Data;

@Data
public class ExcelData {

    private String leftNum;
    private String rightNum;

    public ExcelData(String leftNum, String rightNum){
        this.leftNum = leftNum;
        this.rightNum = rightNum;
    }
}
