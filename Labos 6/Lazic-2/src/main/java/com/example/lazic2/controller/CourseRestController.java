package com.example.lazic2.controller;

import com.example.lazic2.domain.CourseDTO;
import com.example.lazic2.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseRestController {

    private CourseService courseService;

    @Autowired
    public CourseRestController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/all")
    public List<CourseDTO> getAllCourses(){
        return courseService.findAll();
    }

    @GetMapping("/jmbag")
    public List<CourseDTO> getCourseByStudentJmbag(String jmbag){
        return courseService.findByStudents_Jmbag(jmbag);
    }
}
