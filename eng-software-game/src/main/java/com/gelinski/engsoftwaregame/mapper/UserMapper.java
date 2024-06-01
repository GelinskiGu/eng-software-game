package com.gelinski.engsoftwaregame.mapper;

import com.gelinski.engsoftwaregame.dto.UserDTO;
import com.gelinski.engsoftwaregame.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", ignore = true)
    UserDTO entityToDTO(User user);
    User dtoToEntity(UserDTO userDTO);

    List<UserDTO> mapToDTO(List<User> users);
    List<User> mapToEntity(List<UserDTO> userDTO);
}
