package com.example.lazic2.service;

import com.example.lazic2.domain.Student;
import com.example.lazic2.domain.StudentCommand;
import com.example.lazic2.domain.StudentDTO;
import com.example.lazic2.repository.StudentRepository;
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

    @Override
    public Optional<StudentDTO> save(StudentCommand command) {
        if (studentRepository.findStudentByJMBAG(command.getJmbag()).isPresent()){
            return Optional.empty();
        }
        Student student = new Student(command.getFirstName(), command.getLastName(), command.getJmbag(), command.getNumberOfECTS(),command.getDateOfBirth());
        return studentRepository.save(student).map(this::mapStudentToDTO);
    }

    @Override
    public void deleteByJMBAG(String jmbag) {
        studentRepository.deleteByJMBAG(jmbag);
    }

    private StudentDTO mapStudentToDTO(final Student student){
        return new StudentDTO(student.getFirstName(),student.getLastName(),student.getJmbag(),student.getDateOfBirth(),student.checkTuition());
    }
}
