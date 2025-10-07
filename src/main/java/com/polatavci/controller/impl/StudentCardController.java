package com.polatavci.controller.impl;

import com.polatavci.controller.IStudentCardController;
import com.polatavci.dto.StudentCardDto;
import com.polatavci.service.IStudentCardService;
import com.polatavci.service.impl.StudentCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/student-card")
public class StudentCardController implements IStudentCardController {
    final IStudentCardService studentCardService;

    @PutMapping("activate")
    @Override
    public ResponseEntity<StudentCardDto> activateStudentCard(Long id) {
        return ResponseEntity.ok(studentCardService.activateStudentCard(id));
    }

    @PutMapping("deactivate")
    @Override
    public ResponseEntity<StudentCardDto> deactivateStudentCard(Long id) {
        return ResponseEntity.ok(studentCardService.deactivateStudentCard(id));
    }
}
