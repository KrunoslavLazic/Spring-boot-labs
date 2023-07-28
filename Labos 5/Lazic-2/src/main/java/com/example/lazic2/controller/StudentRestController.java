package com.example.lazic2.controller;

import com.example.lazic2.domain.StudentCommand;
import com.example.lazic2.domain.StudentDTO;
import com.example.lazic2.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentRestController {

    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public List<StudentDTO> getAllStudents(){
        return studentService.findAll();
    }

    @GetMapping("/college")
    public List<StudentDTO> findAllByCollege(String college){
        return studentService.findAllByCollege(college);
    }

    @GetMapping("/year")
    public List<StudentDTO> findAllByAcademicYear(String year){
        return studentService.findAllByAcademicYear(year);
    }

    @GetMapping("/jmbag")
    public ResponseEntity<StudentDTO> getStudentByJMBAG(String jmbag){
        return studentService.findStudentsByJMBAG(jmbag)
                .map(
                studentDTO -> ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .body(studentDTO)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NO_CONTENT)
                                .build()
                );
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody final StudentCommand command){
        return studentService.save(command)
                .map(
                        studentDTO -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(studentDTO)
                )
                .orElseGet(
                        ()->ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{JMBAG}")
    public void delete(@PathVariable String JMBAG){
        studentService.deleteByJMBAG(JMBAG);
    }
}
