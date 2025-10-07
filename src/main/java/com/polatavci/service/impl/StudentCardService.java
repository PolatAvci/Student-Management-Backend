package com.polatavci.service.impl;

import com.polatavci.dto.StudentCardDto;
import com.polatavci.entity.Student;
import com.polatavci.entity.StudentCard;
import com.polatavci.mapper.StudentCardMapper;
import com.polatavci.repository.StudentCardRepository;
import com.polatavci.repository.StudentRepository;
import com.polatavci.service.IStudentCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentCardService implements IStudentCardService {
    final StudentCardRepository studentCardRepository;
    final StudentRepository studentRepository;
    final StudentCardMapper studentCardMapper;

    @Override
    public StudentCardDto setStudentCardStatus(Long studentId, boolean status) {
        StudentCard studentCard = studentRepository.findById(studentId)
                .map(Student::getStudentCard) // StudentCard'ı al
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Card Not Found"));

        // Status güncelle
        studentCard.setActive(status);
        studentCardRepository.save(studentCard);

        // DTO dönüşümü
        return studentCardMapper.toStudentCardDto(studentCard);
    }


    @Override
    public StudentCardDto activateStudentCard(Long id) {
        return setStudentCardStatus(id, true);
    }

    @Override
    public StudentCardDto deactivateStudentCard(Long id) {
        return setStudentCardStatus(id, false);
    }
}
