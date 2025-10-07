package com.polatavci.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDto {

        private Long id;

        private String name;

        private String surname;

        private StudentCardSummaryDto studentCard;
}

