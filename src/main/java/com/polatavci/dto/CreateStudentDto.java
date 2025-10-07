package com.polatavci.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentDto {
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private LocalDate dateOfBirth;
}
