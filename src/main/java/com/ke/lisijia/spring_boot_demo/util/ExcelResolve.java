package com.ke.lisijia.spring_boot_demo.util;

import com.ke.lisijia.spring_boot_demo.model.ExcelData;
import jk.excel.ExcelConfig;
import jk.excel.ExcelHeader;
import jk.excel.ExcelUtil;
import jk.excel.parse.Excel;
import jk.excel.parse.ExcelParseFactory;
import jk.excel.parse.Mapping;
import jk.excel.parse.ParseInfo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelResolve {

    private ParseInfo parseInfo;

    public void create(File file)throws IOException {
        ExcelData excelData = null;
        List<ExcelData> data = new ArrayList<>();
        for(int i = 0; i < 10; i ++ ) {
            excelData = new ExcelData(Integer.toString(i), Integer.toString(10-i));
            data.add(excelData);
        }

        List<ExcelHeader> headers = getHeaders();
        ExcelConfig config = new ExcelConfig("测试", headers, data);
        ExcelUtil.write(file, config);
    }

    private List<ExcelHeader> getHeaders(){
        List<ExcelHeader> list = new ArrayList<>();
        ExcelHeader excelHeader = null;
        excelHeader = new ExcelHeader("左","leftNum" , 1, 1, 1, 1 );
        list.add(excelHeader);
        excelHeader = new ExcelHeader("右", "rightNum", 1, 1, 1, 2);
        list.add(excelHeader);
        return list;
    }

    public void prase(File file) {
        parseInfo = new ParseInfo(file, 2);
        parseInfo.setMappings(getMappings());
        parseInfo.addSheet("测试");
        Excel excel = ExcelParseFactory.getExcelParse(parseInfo);
        List<Map> datas = excel.parseToMapList();
        for( Map map : datas){
            System.out.println( "leftNumber:" + map.get("leftNum")+"rightNumber:" + map.get("rightNum"));
        }
    }

    public static List<Mapping> getMappings() {
        List<Mapping> list = new ArrayList<>();
        Mapping mapping = new Mapping("leftNum","左");
        list.add(mapping);
        mapping = new Mapping("rightNum", "右");
        list.add(mapping);
        return list;
    }

    public static void main(String args[]){
        File file = new File("C:\\Users\\Administrator\\Desktop\\excel.xlsx");
        new ExcelResolve().prase(file);
//        try{
//            new ExcelResolve().create(file);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
    }
}
