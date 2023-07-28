package com.example.lazic2.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="jmbag")
    private String jmbag;

    @Column(name="ects_points")
    private Integer numberOfECTS;

    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name="town_name")
    private String townName;

    @Column(name="college_name")
    private String collegeName;

    @Column(name="academic_year")
    private Integer academicYear;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name="student_course",
            joinColumns = {@JoinColumn(name="student_id")},
            inverseJoinColumns = {@JoinColumn(name="course_id")}
    )
    private List<Course> courses;

    public Student(long l, String firstName, String lastName, String jmbag, Integer numberOfECTS, LocalDate dateOfBirth, String townName, String collegeName, Integer academicYear) {
        this.id=l;
        this.firstName=firstName;
        this.lastName = lastName;
        this.jmbag=jmbag;
        this.numberOfECTS=numberOfECTS;
        this.dateOfBirth=dateOfBirth;
        this.townName = townName;
        this.academicYear=academicYear;
        this.collegeName=collegeName;
    }


    public boolean checkTuition(){
        Period age = Period.between(this.dateOfBirth,LocalDate.now());
        return age.getYears() >= 26;
    }

    @Override
    public String toString() {
        return jmbag + " - " +
                firstName + ' '
                + lastName;
    }
}
