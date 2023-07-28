package com.example.lazic2.repository;

import com.example.lazic2.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentJpaRepository extends JpaRepository<Student,Long> {

    // FIRST
    List<Student> findFirstByOrderById();

    //DISTINCT
    List<Student> findDistinctByFirstName(String firstName);

    //TOP
    List<Student> findTop2ByOrderByNumberOfECTSDesc();

    //EQUALS
    List<Student> findByFirstNameEquals(String name);

    //NOT
    List<Student> findByCollegeNameNot(String collegeName);

    //IS
    List<Student> findByAcademicYearIs(Integer academicYear);

    //IN
    List<Student> findByTownNameIn(List<String> townNames);

    //NOT IN
    List<Student> findByAcademicYearNotIn(List<Integer> academicYears);

    //True False
    List<Student> findByNumberOfECTSGreaterThanEqual(Integer ects);

    @Query("SELECT s FROM Student s WHERE s.townName= :town OR s.collegeName=:college")
    List<Student> findByTownOrCollege(String town, String college);






}
