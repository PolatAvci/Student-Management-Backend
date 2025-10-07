package com.polatavci.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
// @JsonInclude(JsonInclude.Include.NON_NULL) // null olan alanlar jsonda görünmez
// student alanının görünmemesi için student alanı kaldırılabilir ya da bu alanın olmadığı farkı bir dto açılabilir
public class StudentCardDto {

    private Long id;

    private String cardNumber;

    private Boolean active;

    @JsonInclude(JsonInclude.Include.NON_NULL) // Bu alan  null olduğunda jsonda görünmez
    private StudentSummaryDto student;
}
