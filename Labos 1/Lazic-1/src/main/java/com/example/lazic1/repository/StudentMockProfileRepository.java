package com.example.lazic1.repository;

import com.example.lazic1.domain.Student;
import com.example.lazic1.domain.StudentDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
@Profile("prod")
public class StudentMockProfileRepository implements StudentRepository{

    private List<Student> studentList;

    public StudentMockProfileRepository(){

        studentList= new ArrayList<>();
        studentList.add(new Student("Pero","Perić","0246098874",36,LocalDate.of(2001,7,9)));
        studentList.add(new Student("Ivo","Ivić","0123456789",36,LocalDate.of(2000,5,5)));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Optional<Student> findStudentByJMBAG(String jmbag) {
        return studentList.stream().filter(s->s.getJmbag().equals(jmbag)).findAny();
    }

    @Override
    public List<Student> filteredStudents() {
        return studentList.stream().filter(s->s.getIme().length()>5).collect(Collectors.toList());
    }
}
