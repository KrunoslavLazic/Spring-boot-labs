package com.example.lazic1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String ime;
    private String prezime;
    private String jmbag;
    private Integer numberOfECTS;
    private LocalDate dateOfBirth;

    public boolean checkTuition(){
        Period age = Period.between(this.dateOfBirth,LocalDate.now());
        return age.getYears() >= 26;
    }

}
