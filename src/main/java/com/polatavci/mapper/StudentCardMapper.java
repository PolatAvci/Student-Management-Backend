package com.polatavci.mapper;

import com.polatavci.dto.StudentCardDto;
import com.polatavci.entity.StudentCard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StudentCardMapper {

    // student dönüşümünü yapmaz, otomatik olarak null atar (amaç sonsuz döngü oluşturmamak). Bunu zaten yaptığından eklemedim
    // @Mapping(source = "student", target = "student", ignore = true)
    StudentCardDto  toStudentCardDto(StudentCard studentCard);

    StudentCard toStudentCard(StudentCardDto studentCardDto);
}
