package com.polatavci.service.impl;


import com.polatavci.dto.CreateStudentDto;
import com.polatavci.dto.StudentDto;
import com.polatavci.entity.Student;
import com.polatavci.entity.StudentCard;
import com.polatavci.mapper.StudentMapper;
import com.polatavci.repository.StudentRepository;
import com.polatavci.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;


    @Override
    public StudentDto addStudent(CreateStudentDto createStudent) {
        Student student = studentMapper.toStudent(createStudent);
        StudentCard studentCard = new StudentCard();
        studentCard.setCardNumber(UUID.randomUUID().toString());
        studentCard.setActive(true);
        student.setStudentCard(studentCard);
        return studentMapper.toStudentDto(studentRepository.save(student));
    }

    @Override
    public List<StudentDto> getAllStudent() {
        return studentMapper.toStudentDtoList(studentRepository.findAll());
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
        return studentMapper.toStudentDto(optional.orElse(null));
    }

    @Override
    public void deleteStudentById(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
        optional.ifPresentOrElse(studentRepository::delete, () -> {
            throw new RuntimeException("Student not found with id: " + id);
        });
    }

    @Override
    public StudentDto updateStudentById(Long id, CreateStudentDto createStudentDto) {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            Student student = optional.get();
            studentMapper.updateStudent(createStudentDto, student);

            return studentMapper.toStudentDto(studentRepository.save(student));
        }
        throw new RuntimeException("Student not found with id: " + id);
    }

    @Override
    public List<StudentDto> getStudentsGreaterThanAge(Integer age) {
        return studentMapper.toStudentDtoList(studentRepository.getStudentsGreaterThanAge(age));
    }

    public List<StudentDto> getStudentsByName(String name){
        return studentMapper.toStudentDtoList(studentRepository.getStudentsByName(name));
    }


}
