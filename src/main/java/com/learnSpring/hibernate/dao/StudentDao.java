package com.learnSpring.hibernate.dao;

import com.learnSpring.hibernate.entity.Student;

public interface StudentDao {
    public void save(Student student);
    public Student findById(int id);
}
