package com.example.lazic2.service;

import com.example.lazic2.domain.Course;
import com.example.lazic2.domain.CourseDTO;
import com.example.lazic2.repository.CourseJpaRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class CourseServiceImplementation implements CourseService {

    private CourseJpaRepository courseRepository;

    @Autowired
    public CourseServiceImplementation(CourseJpaRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> findAll() {
        List<CourseDTO> list = courseRepository.findAll().stream()
                .map(this::mapCourseToDTO).collect(Collectors.toList());
        System.out.println(list);
        return list;
    }

    @Override
    public List<CourseDTO> findByStudents_Jmbag(String jmbag) {
        return courseRepository.findByStudents_Jmbag(jmbag).stream()
                .map(this::mapCourseToDTO).collect(Collectors.toList());
    }

    private CourseDTO mapCourseToDTO(final Course course){
        return new CourseDTO(
                course.getName(),
                course.getEcts_points(),
                course.getStudents()
        );
    }
}
