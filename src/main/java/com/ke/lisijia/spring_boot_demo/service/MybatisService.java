package com.ke.lisijia.spring_boot_demo.service;

import com.ke.lisijia.spring_boot_demo.model.Student;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
        return student.toString();
    }

    public String insertStudent() {
        Student student = randomStudent();
        mybatisDao.insertStudent(student);
        return student.toString();
    }

    private static Student randomStudent() {
        Student student = new Student();
        student.setName(RandomStringUtils.randomAlphabetic(3));
        student.setGender(new Random().nextInt(2) >= 1 ? "男" : "女");
        student.setGrade(new Random().nextInt(3)+1);
        student.setClassroom(new Random().nextInt(6)+1);
        student.setScore(new Random().nextInt(101));
        return student;
    }

    public String deleteStudent(int id) {
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

}
