package com.example.lazic2.repository;

import com.example.lazic2.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseJpaRepository extends JpaRepository<Course,Long> {

    List<Course> findAll();
    List<Course> findByStudents_Jmbag(String jmbag);

}
