package com.example.lazic2.service;

import com.example.lazic2.domain.*;
import com.example.lazic2.repository.StudentRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class StudentServiceImplementation implements StudentService{

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImplementation(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream()
                .map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDTO> findStudentsByJMBAG(String jmbag) {
        return studentRepository.findStudentByJMBAG(jmbag).map(this::mapStudentToDTO);
    }

    @Override
    public Optional<StudentDTO> save(StudentCommand command) {
        if (studentRepository.findStudentByJMBAG(command.getJmbag()).isPresent()){
            return Optional.empty();
        }
        Student student = new Student(0L,command.getFirstName(), command.getLastName(),
                command.getJmbag(),
                command.getNumberOfECTS(),
                command.getDateOfBirth(),
                command.getTownName(),
                command.getCollegeName(),
                command.getAcademicYear());
        return studentRepository.save(student).map(this::mapStudentToDTO);
    }

    @Override
    public void deleteByJMBAG(String jmbag) {
        studentRepository.deleteByJMBAG(jmbag);
    }

    @Override
    public List<StudentDTO> findAllByCollege(String collegeName) {
        return studentRepository.findAllByCollege(collegeName).stream()
                .map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> findAllByAcademicYear(String academicYear) {
        return studentRepository.findAllByAcademicYear(academicYear).stream()
                .map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    private StudentDTO mapStudentToDTO(final Student student){
        return new StudentDTO(
                student.getFirstName(),
                student.getLastName(),
                student.getJmbag(),
                student.getDateOfBirth(),
                student.checkTuition(),
                student.getTownName(),
                student.getCollegeName(),
                student.getAcademicYear());
    }

}
