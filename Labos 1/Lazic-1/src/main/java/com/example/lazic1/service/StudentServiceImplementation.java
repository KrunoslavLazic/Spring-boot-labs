package com.example.lazic1.service;

import com.example.lazic1.domain.Student;
import com.example.lazic1.domain.StudentDTO;
import com.example.lazic1.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImplementation implements StudentService{

    private StudentRepository studentRepository;

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDTO> findStudentsByJMBAG(String jmbag) {
        return studentRepository.findStudentByJMBAG(jmbag).map(this::mapStudentToDTO);
    }

    @Override
    public List<StudentDTO> filteredStudents() {
        return studentRepository.filteredStudents().stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    private StudentDTO mapStudentToDTO(final Student student){
        return new StudentDTO(student.getIme(),student.getPrezime(),student.getJmbag(),student.getDateOfBirth(),student.checkTuition());
    }
}
