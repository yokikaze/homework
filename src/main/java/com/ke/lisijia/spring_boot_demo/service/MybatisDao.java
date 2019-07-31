package com.ke.lisijia.spring_boot_demo.service;

import com.ke.lisijia.spring_boot_demo.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MybatisDao {
    /**
     * 获取全部学生信息
     * @return List<Student>队列
     */
    List<Student> findAll();

    /**
     * 添加学生
     * @param student
     * @return 添加的学生数量
     */
    void insertStudent(Student student);

    /**
     * 删除学生
     * @param student 需要删除的学生
     * @return
     */
    void deleteStudent(Student student);

    /**
     *更新学生数据
     * @param student
     * @return 更新前的学生信息
     */
    void updateStudent(Student student);

    /**
     * 根据主键ID查找学生
     * @param id
     * @return {@link Student}
     */
    Student findById(int id);
}
