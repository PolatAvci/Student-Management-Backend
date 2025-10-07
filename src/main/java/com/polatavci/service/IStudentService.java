package com.polatavci.service;

import com.polatavci.dto.CreateStudentDto;
import com.polatavci.dto.StudentDto;
import com.polatavci.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IStudentService {

    StudentDto addStudent(CreateStudentDto createStudent);
    List<StudentDto> getAllStudent();
    StudentDto getStudentById(Long id);
    void deleteStudentById(Long id);
    StudentDto updateStudentById(Long id, CreateStudentDto createStudent);
    List<StudentDto> getStudentsGreaterThanAge(Integer age);
    List<StudentDto> getStudentsByName(String name);
}
