package com.example.lazic2.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue
    private long id;

    private String name;
    @Column(name="ects_points")
    private Integer ects_points;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "courses")
    private List<Student> students;

}
