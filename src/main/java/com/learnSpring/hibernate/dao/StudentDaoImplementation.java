package com.learnSpring.hibernate.dao;

import com.learnSpring.hibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImplementation implements StudentDao {
    EntityManager entityManager;
    public StudentDaoImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        String jpql = "SELECT s FROM Student s";
        TypedQuery<Student> myQuery = entityManager.createQuery(jpql,Student.class);
        return myQuery.getResultList();
    }
}
