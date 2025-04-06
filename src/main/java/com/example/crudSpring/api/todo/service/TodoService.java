package com.example.crudSpring.api.todo.service;

import com.example.crudSpring.api.todo.dto.TodoDTO;
import com.example.crudSpring.api.todo.mapper.TodoMapper;
import com.example.crudSpring.api.todo.model.Todo;
import com.example.crudSpring.api.todo.respository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoMapper todoMapper;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo create(TodoDTO todoDTO) {
        Todo todo = todoMapper.toEntity(todoDTO);

        return todoRepository.save(todo);
    }
}
