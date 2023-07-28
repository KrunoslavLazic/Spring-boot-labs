package com.example.lazic2.service;

import com.example.lazic2.domain.CourseDTO;

import java.util.List;

public interface CourseService {

    List<CourseDTO> findAll();
    List<CourseDTO> findByStudents_Jmbag(String jmbag);

}
