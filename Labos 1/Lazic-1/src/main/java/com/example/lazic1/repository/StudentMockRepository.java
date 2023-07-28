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
@Profile("dev")
public class StudentMockRepository implements StudentRepository{

    private List<Student> studentList;

    public StudentMockRepository(){

        studentList= new ArrayList<>();
        studentList.add(new Student("Pero","Perić","0246098874",36,LocalDate.of(2001,7,9)));
        studentList.add(new Student("Ivo","Ivić","0123456789",36,LocalDate.of(2000,5,5)));
        studentList.add(new Student("Stjepan","Stipić","0123456789",36,LocalDate.of(2000,5,5)));
        studentList.add(new Student("Domagoj","Dostojevski","0123456789",36,LocalDate.of(2000,5,5)));
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
        return studentList.stream()
                .filter(s->s.getIme().length()>=5)
                .filter(p->p.getPrezime().length()>=10)
                .collect(Collectors.toList());
    }
}
