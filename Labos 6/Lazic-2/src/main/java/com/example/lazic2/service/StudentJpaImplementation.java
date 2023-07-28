package com.example.lazic2.service;

import com.example.lazic2.domain.Student;
import com.example.lazic2.domain.StudentDTO;
import com.example.lazic2.repository.StudentJpaRepository;
import com.example.lazic2.repository.StudentRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class StudentJpaImplementation implements StudentJpaService{

    private StudentJpaRepository studentJpaRepository;

    @Override
    public List<StudentDTO> getFirstStudent() {
        return studentJpaRepository.findFirstByOrderById()
                .stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }


    @Override
    public List<StudentDTO> getStudentsByFirstName(String firstName) {
        return studentJpaRepository.findByFirstNameEquals(firstName)
                .stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getStudentsByAcademicYearIs(Integer academicYear) {
        return studentJpaRepository.findByAcademicYearIs(academicYear)
                .stream().map(this::mapStudentToDTO).collect(Collectors.toList());

    }
    @Override
    public List<StudentDTO> getStudentsByCollegeNameNot(String collegeName) {
        return studentJpaRepository.findByCollegeNameNot(collegeName)
                .stream().map(this::mapStudentToDTO).collect(Collectors.toList());

    }

    @Override
    public List<StudentDTO> getStudentsFromTowns(List<String> townNames) {
        return studentJpaRepository.findByTownNameIn(townNames)
                .stream().map(this::mapStudentToDTO).collect(Collectors.toList());

    }

    @Override
    public List<StudentDTO> getHalfDoneStudents() {
        return studentJpaRepository.findByNumberOfECTSGreaterThanEqual(90)
                .stream().map(this::mapStudentToDTO).collect(Collectors.toList());

    }

    @Override
    public List<StudentDTO> getTop2StudentByECTS() {
        return studentJpaRepository.findTop2ByOrderByNumberOfECTSDesc()
                .stream().map(this::mapStudentToDTO).collect(Collectors.toList());

    }

    @Override
    public List<StudentDTO> getStudentNotFirstYear() {
        List<Integer> firstAcademicYear = List.of(1);
        return studentJpaRepository.findByAcademicYearNotIn(firstAcademicYear)
                .stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getStudentsDistinctName(String name) {
        return studentJpaRepository.findDistinctByFirstName(name)
                .stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getStudentsTownOrCollege(String town, String college) {
        return studentJpaRepository.findByTownOrCollege(town,college)
                .stream().map(this::mapStudentToDTO).collect(Collectors.toList());
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
