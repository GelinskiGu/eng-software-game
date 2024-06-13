package com.gelinski.engsoftwaregame.mapper;

import com.gelinski.engsoftwaregame.dto.GroupDTO;
import com.gelinski.engsoftwaregame.model.Group;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GroupMapper {
    @Mapping(target = "teacher", ignore = true)
    Group toEntity(GroupDTO groupDTO);
    @Mapping(target = "teacher", ignore = true)
    @Mapping(target = "id", ignore = true)
    GroupDTO toDto(Group group);
}