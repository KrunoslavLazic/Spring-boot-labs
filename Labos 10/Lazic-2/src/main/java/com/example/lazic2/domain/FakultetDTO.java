package com.example.lazic2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FakultetDTO {

    private String name;
    private String city;
    private Integer numberOfStudents;

}
