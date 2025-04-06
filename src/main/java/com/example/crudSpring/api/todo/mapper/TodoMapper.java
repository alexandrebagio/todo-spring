package com.example.crudSpring.api.todo.mapper;

import com.example.crudSpring.api.todo.dto.TodoDTO;
import com.example.crudSpring.api.todo.model.Todo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo toEntity(TodoDTO todoDTO);
}
