package com.example.lazic1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private String ime;
    private String prezime;
    private String jmbag;
    private LocalDate dateOfBirth;
    private boolean payedTuition;


}
