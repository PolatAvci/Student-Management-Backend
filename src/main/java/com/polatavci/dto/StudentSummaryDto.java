package com.polatavci.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Döngü oluşmaması için Referanssız Dto
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentSummaryDto {
    private Long id;

    private String name;

    private String surname;
}
