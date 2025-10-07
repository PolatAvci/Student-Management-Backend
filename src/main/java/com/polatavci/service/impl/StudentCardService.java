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
    public StudentCardDto setStudentCardStatus(Long id, boolean status) {
        final Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()) {
            final Optional<StudentCard> optionalStudentCard = studentCardRepository.findById(optionalStudent.get().getStudentCard().getId());
            if(optionalStudentCard.isPresent()) {
                final StudentCard studentCard = optionalStudentCard.get();
                studentCard.setActive(status);
                studentCardRepository.save(studentCard);
                studentCard.setStudent(optionalStudent.get());

                return studentCardMapper.toStudentCardDto(studentCard);
            }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Card Not Found");
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Not Found");
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
