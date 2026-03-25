package com.techacademy.trainbase.mapper;

import com.techacademy.trainbase.dto.CommentDTO;
import com.techacademy.trainbase.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentDTO toDTO(Comment comment);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Comment toEntity(CommentDTO commentDTO);

    @Mapping(target = "createdAt", ignore = true)
    Comment toEntityWithId(CommentDTO commentDTO);
}
