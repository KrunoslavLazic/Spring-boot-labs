package com.example.lazic2.domain;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
@Data
public class StudentCommand {

    @NotBlank(message = "First name must not be empty")
    private String firstName;

    @NotBlank(message = "Last name must not be empty")
    private String lastName;

    @NotBlank(message = "JMBAG must not be empty")
    @Pattern(message = "JMBAG must have 10 digits", regexp="[\\d]{10}")
    private String jmbag;

    @NotNull(message = "Date of birth must be entered")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotNull(message = "Number of ECTS points must be entered")
    @PositiveOrZero(message = "Number of ECTS must be entered as a positive integer")
    @Max(message = "Number of ECTS can not be higher than 480", value = 480)
    private Integer numberOfECTS;

    @NotNull(message = "Town name must be entered")
    private String townName;

    @NotNull(message = "College name must be entered")
    private String collegeName;

    @NotNull(message = "Academic year must be entered")
    @Positive
    private Integer academicYear;


}
