package com.polatavci.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Döngü oluşmaması için Referanssız Dto
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentCardSummaryDto {

    private Long id;

    private String cardNumber;

    private Boolean active;
}
