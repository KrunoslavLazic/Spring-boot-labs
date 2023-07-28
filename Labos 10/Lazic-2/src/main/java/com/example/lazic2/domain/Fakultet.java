package com.example.lazic2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fakultet {

    private String name;
    private String city;
    private String oib;
    private Integer numberOfStudents;
    private BigDecimal averageGrade;
    private boolean isFree;

}
