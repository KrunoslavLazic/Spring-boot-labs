package com.example.lazic2.repository;

import com.example.lazic2.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    List<Student> findAll();

    Optional<Student> findStudentByJMBAG(String jmbag);

    List<Student> filteredStudents();

    Optional<Student> save(Student student);

    void deleteByJMBAG(String jmbag);

}
