package com.polatavci.service;

import com.polatavci.dto.StudentCardDto;

public interface IStudentCardService {
    StudentCardDto setStudentCardStatus(Long id, boolean status);
    StudentCardDto activateStudentCard(Long id);
    StudentCardDto deactivateStudentCard(Long id);
}
