package com.luv2code.crud.dao;

import com.luv2code.crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student getById(Integer id);

}
