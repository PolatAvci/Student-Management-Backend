package com.polatavci.controller.impl;

import com.polatavci.controller.IStudentController;
import com.polatavci.dto.CreateStudentDto;
import com.polatavci.dto.StudentDto;
import com.polatavci.entity.Student;
import com.polatavci.service.IStudentService;
import com.polatavci.service.impl.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController implements IStudentController {

    private final StudentService studentService;

    @Override
    @PostMapping
    public ResponseEntity<StudentDto> addStudent(@Valid @RequestBody CreateStudentDto createStudentDto) {
        return ResponseEntity.ok(studentService.addStudent(createStudentDto));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudents() {
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable Long id, @Valid @RequestBody CreateStudentDto createStudentDto) {
        return ResponseEntity.ok(studentService.updateStudentById(id, createStudentDto));
    }

    @Override
    @GetMapping("greater-than-age/{age}")
    public ResponseEntity<List<StudentDto>> getStudentsGreaterThanAge(@PathVariable Integer age) {
        return ResponseEntity.ok(studentService.getStudentsGreaterThanAge(age));
    }

    @Override
    @GetMapping("by-name")
    public ResponseEntity<List<StudentDto>> getStudentsByName(String name) {
        return ResponseEntity.ok(studentService.getStudentsByName(name));
    }
}
