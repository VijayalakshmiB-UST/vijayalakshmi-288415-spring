package com.techacademy.trainbase.mapper;

import com.techacademy.trainbase.dto.UserCreateDTO;
import com.techacademy.trainbase.dto.UserDTO;
import com.techacademy.trainbase.dto.UserUpdateDTO;
import com.techacademy.trainbase.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    User toEntity(UserCreateDTO userCreateDTO);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateEntityFromDTO(UserUpdateDTO userUpdateDTO, @MappingTarget User user);
}
