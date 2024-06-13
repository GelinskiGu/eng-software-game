package com.gelinski.engsoftwaregame.mapper;

import com.gelinski.engsoftwaregame.dto.StudentDTO;
import com.gelinski.engsoftwaregame.model.Student;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {
    @Mapping(target = "group", ignore = true)
    Student toEntity(StudentDTO studentDTO);
    @Mapping(target = "group", ignore = true)
    @Mapping(target = "id", ignore = true)
    StudentDTO toDto(Student student);
}