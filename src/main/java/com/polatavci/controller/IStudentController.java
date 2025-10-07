package com.polatavci.controller;

import com.polatavci.dto.CreateStudentDto;
import com.polatavci.dto.StudentDto;
import com.polatavci.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStudentController {

    ResponseEntity<StudentDto> addStudent(CreateStudentDto createStudentDto);

    ResponseEntity<List<StudentDto>> getStudents();

    ResponseEntity<StudentDto> getStudentById(Long id);

    ResponseEntity<Void> deleteStudentById(Long id);

    ResponseEntity<StudentDto> updateStudentById(Long id, CreateStudentDto createStudentDto);

    ResponseEntity<List<StudentDto>> getStudentsGreaterThanAge(Integer age);

    ResponseEntity<List<StudentDto>> getStudentsByName(String name);
}
