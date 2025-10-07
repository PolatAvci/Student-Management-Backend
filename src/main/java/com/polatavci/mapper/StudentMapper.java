package com.polatavci.mapper;


import com.polatavci.dto.CreateStudentDto;
import com.polatavci.dto.StudentDto;
import com.polatavci.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "name", target = "name") // Aynı olursa yazılmayabilir
    Student toStudent(CreateStudentDto createStudentDto);

    Student toStudent(Student student);

    StudentDto toStudentDto(Student student);

    CreateStudentDto toCreateStudentDto(Student student);

    // var olan nesnenin değerlerini MappingTarget ile işaretlenen alana aktarır
    void updateStudent(CreateStudentDto createStudentDto, @MappingTarget Student updateStudent);

    List<StudentDto> toStudentDtoList(List<Student> students);
}
