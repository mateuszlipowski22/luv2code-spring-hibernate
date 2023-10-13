package com.luv2code.crud.dao;

import com.luv2code.crud.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findAllByLastName(String lastName);

    void update(Student student);
    
    void delete(Integer id);

    int deleteAll();
}
