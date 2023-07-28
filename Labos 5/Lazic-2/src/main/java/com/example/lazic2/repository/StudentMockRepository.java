package com.example.lazic2.repository;

import com.example.lazic2.domain.Student;
import com.example.lazic2.domain.StudentDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
@Profile("dev")
public class StudentMockRepository implements StudentRepository{

    private List<Student> studentList;

    public StudentMockRepository(){

        studentList= new ArrayList<>();
        // studentList.add(new Student("Pero","Perić","0246098874",36,LocalDate.of(2001,7,9)));
        // studentList.add(new Student("Ivo","Ivić","0123456789",36,LocalDate.of(2000,5,5)));
        // studentList.add(new Student("Stjepan","Stipić","0123456789",36,LocalDate.of(2000,5,5)));
        // studentList.add(new Student("Domagoj","Dostojevski","0123456789",36,LocalDate.of(2000,5,5)));
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
    public Optional<Student> save(Student student) {
        studentList.add(student);
        return Optional.ofNullable(student);
    }

    @Override
    public void deleteByJMBAG(String jmbag) {
        studentList.removeIf(s -> s.getJmbag().equals(jmbag));
    }

    @Override
    public List<Student> findAllByCollege(String collegeName) {
        return null;
    }

    @Override
    public List<Student> findAllByAcademicYear(String academicYear) {
        return null;
    }

}
