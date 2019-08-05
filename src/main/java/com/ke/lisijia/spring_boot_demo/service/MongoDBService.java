package com.ke.lisijia.spring_boot_demo.service;

import com.alibaba.fastjson.JSON;
import com.ke.lisijia.spring_boot_demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoDBService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Student insertStudent(Student student) {
        mongoTemplate.insert(student);
        return student;
    }

    public Student updateStudent(Student student) {
        Query query = Query.query(Criteria.where("id").is(student.getId()));
        mongoTemplate.save(student);
        return student;
    }

    public void deleteStudent(int id) {
        Query query = Query.query(Criteria.where("id").is(id));
        mongoTemplate.remove(query);
    }

    public Student findById(int id) {
        Query query = Query.query(Criteria.where("id").is(id));
        return mongoTemplate.find(query, Student.class).get(0);
    }

    public List<Student> findAll() {
       return mongoTemplate.findAll(Student.class);
    }
}
