package com.example.lazic2.domain;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class FakultetCommand {

    @NotBlank(message = "Name must be specified")
    @Size(min = 3, max = 20)
    private String name;

    @NotBlank(message = "City must be specified")
    private String city;

    @NotBlank(message = "OIB must be specified")
    private String oib;

    @NotNull(message = "Number of students must be specified")
    @PositiveOrZero(message = "Number of students must a non negative integer")
    private Integer numberOfStudents;

    @DecimalMin(value = "1.0", message = "Average grade cannot be lower than 1")
    @DecimalMax(value = "5.0", message = "Average grade cannot be higher than 1")
    private BigDecimal averageGrade;

    @NotNull(message = "Is free or not must be specified")
    private boolean isFree;

}
