package com.learnSpring.hibernate.dao;

import com.learnSpring.hibernate.entity.Student;

import java.util.List;

public interface StudentDao {
    public void save(Student student);
    public Student findById(int id);
    public List<Student> findAll();
    public List<Student> findByLastName(String someLastName);
    public void update(int id, String newLastName);
    public void deleteById(int id);
    public void deleteAll();
}
