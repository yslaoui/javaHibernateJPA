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
        String jpql = "SELECT s FROM Student s ORDER BY s.lastName";
        TypedQuery<Student> myQuery = entityManager.createQuery(jpql,Student.class);
        return myQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String someLastName) {
        String jpql = "SELECT s FROM Student s WHERE s.lastName=:lastNameParameter";
        TypedQuery<Student> myQuery = entityManager.createQuery(jpql, Student.class);
        myQuery.setParameter("lastNameParameter", someLastName);
        return myQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(int id, String newLastName) {
        Student studentToUpdate = entityManager.find(Student.class, id);
        studentToUpdate.setLastName(newLastName);
        System.out.println("Student to update in the DAO is " + studentToUpdate);
        entityManager.merge(studentToUpdate);
    }
}


