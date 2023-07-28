package com.example.lazic2.service;

import com.example.lazic2.domain.StudentCommand;
import com.example.lazic2.domain.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<StudentDTO> findAll();

    Optional<StudentDTO> findStudentsByJMBAG(String jmbag);

    List<StudentDTO> filteredStudents();

    Optional<StudentDTO> save(StudentCommand command);

    void deleteByJMBAG(String jmbag);


}
