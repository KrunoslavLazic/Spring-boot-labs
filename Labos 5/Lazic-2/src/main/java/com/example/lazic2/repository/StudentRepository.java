package com.example.lazic2.repository;

import com.example.lazic2.domain.Student;
import com.example.lazic2.domain.StudentDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface StudentRepository {

    List<Student> findAll();

    Optional<Student> findStudentByJMBAG(String jmbag);

    Optional<Student> save(Student student);

    void deleteByJMBAG(String jmbag);

    List<Student> findAllByCollege(String collegeName);

    List<Student> findAllByAcademicYear(String academicYear);

}
