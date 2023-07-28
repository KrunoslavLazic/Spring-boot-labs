package com.example.lazic1.service;

import com.example.lazic1.domain.Student;
import com.example.lazic1.domain.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<StudentDTO> findAll();

    Optional<StudentDTO> findStudentsByJMBAG(String jmbag);

    List<StudentDTO> filteredStudents();

}
