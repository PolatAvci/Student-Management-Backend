package com.polatavci.controller;

import com.polatavci.dto.StudentCardDto;
import org.springframework.http.ResponseEntity;

public interface IStudentCardController {
    ResponseEntity<StudentCardDto> activateStudentCard(Long id);
    ResponseEntity<StudentCardDto> deactivateStudentCard(Long id);
}
