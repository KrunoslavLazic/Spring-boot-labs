package com.example.lazic2.service;

import com.example.lazic2.domain.Student;
import com.example.lazic2.domain.StudentDTO;

import java.util.List;

public interface StudentJpaService {

    List<StudentDTO> getFirstStudent();
    List<StudentDTO> getStudentsByFirstName(String firstName);
    List<StudentDTO> getStudentsByAcademicYearIs(Integer academicYear);
    List<StudentDTO> getStudentsByCollegeNameNot(String collegeName);
    List<StudentDTO> getStudentsFromTowns(List<String> townNames);
    List<StudentDTO> getHalfDoneStudents();
    List<StudentDTO> getTop2StudentByECTS();
    List<StudentDTO> getStudentNotFirstYear();
    List<StudentDTO> getStudentsDistinctName(String name);
    List<StudentDTO> getStudentsTownOrCollege(String town, String college);




}
