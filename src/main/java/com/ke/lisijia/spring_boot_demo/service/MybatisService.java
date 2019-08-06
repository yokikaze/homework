package com.ke.lisijia.spring_boot_demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ke.lisijia.spring_boot_demo.model.Student;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class MybatisService {

    @Autowired
    MybatisDao mybatisDao;

    public String findAll() {
        List<Student> students = mybatisDao.findAll();
        StringBuffer stringBuffer = new StringBuffer();
        students.forEach(a-> {
            stringBuffer.append(a.toString());
            stringBuffer.append("\n");
        });
      //  System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

    public String findById(int id) {
        Student student = mybatisDao.findById(id);
        if(student == null) {
            return "null";
        }
        return student.toString();
    }

    public Student insertStudent(String jsonStudent) {
        Student student = JSONObject.parseObject(jsonStudent, Student.class);
        if(findById(student.getId())!="null" ){
            return null;
        }
        mybatisDao.insertStudent(student);
        return student;
    }

    public static Student randomStudent() {
        Student student = new Student();
        Random random = new Random();
        student.setId(random.nextInt(100));
        student.setName(RandomStringUtils.randomAlphabetic(3));
        student.setGender(random.nextInt(2) >= 1 ? "男" : "女");
        student.setGrade(random.nextInt(3)+1);
        student.setClassroom(random.nextInt(6)+1);
        student.setScore(random.nextInt(101));
        return student;
    }

    public String deleteStudent(String idString) {
        int id = Integer.parseInt(idString);
        Student student = mybatisDao.findById(id);
        mybatisDao.deleteStudent(student);
        return student.toString();
    }

    public String updateStudent() {
        List<Student> list = mybatisDao.findAll();
        int random = new Random().nextInt(list.size());
        Student student = randomStudent();
        student.setId(list.remove(random).getId());
        mybatisDao.updateStudent(student);
        return student.toString();
    }

    public String updateStudent(Student student) {
        mybatisDao.updateStudent(student);
        return student.toString();
    }

    public String updateName(int id, String name){
        Student student = mybatisDao.findById(id);
        student.setName(name);
        mybatisDao.updateStudent(student);
        return student.toString();
    }

    public Student updateStudentGender(String gender){
        Student student = mybatisDao.findById(1);
        student.setGender(gender);
        mybatisDao.updateStudent(student);
        return student;
    }

    @Cacheable(value = "demo",key = "'demo:'+#name", unless = "#result==null")
    public String findByName(String name) {
        return JSON.toJSONString(mybatisDao.findByName(name));
    }
}
