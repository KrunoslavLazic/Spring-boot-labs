package com.example.lazic1.controller;

import com.example.lazic1.domain.Student;
import com.example.lazic1.domain.StudentDTO;
import com.example.lazic1.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students")
@AllArgsConstructor
public class StudentRestController {

    private StudentService studentService;

    @GetMapping("all")
    public List<StudentDTO> getAllStudents(){
        return studentService.findAll();
    }

    @GetMapping("jmbag")
    public Optional<StudentDTO> getStudentByJMBAG(String jmbag){
        return studentService.findStudentsByJMBAG(jmbag);
    }

    @GetMapping("5ime10prezime")
    public List<StudentDTO> getFilteredStudent(){
        return studentService.filteredStudents();
    }



}
