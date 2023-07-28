package com.example.lazic2.controller;

import com.example.lazic2.domain.StudentCommand;
import com.example.lazic2.domain.StudentDTO;
import com.example.lazic2.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("5ime10prezime")
    public List<StudentDTO> getFilteredStudent(){
        return studentService.filteredStudents();
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
