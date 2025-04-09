package com.example.todo.api.todo.service;

import com.example.todo.api.todo.dto.TodoDTO;
import com.example.todo.api.todo.mapper.TodoMapper;
import com.example.todo.api.todo.model.Todo;
import com.example.todo.api.todo.respository.TodoRepository;
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

    public Todo findById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    public Todo create(TodoDTO todoDTO) {
        Todo todo = todoMapper.toEntity(todoDTO);

        return todoRepository.save(todo);
    }

    public Todo update(Long id, TodoDTO todoDTO) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));

        todoMapper.updateEntity(todoDTO, todo);

        return todoRepository.save(todo);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
