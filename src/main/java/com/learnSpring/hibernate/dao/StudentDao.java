package com.learnSpring.hibernate.dao;

import com.learnSpring.hibernate.entity.Student;

import java.util.List;

public interface StudentDao {
    public void save(Student student);
    public Student findById(int id);
    public List<Student> findAll();
}
