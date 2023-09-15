package com.chad.cruddemo.dao;

import com.chad.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Long id);

    List<Student> findAll();

    List<Student> findByLastname(String lastName);

    void update(Student student);

    void updateAllStudents(String lastName);

    void delete(Student student, Long studentId);

    int deleteAllStudents();
}
