package com.example.crudSpring.api.todo.controller;

import com.example.crudSpring.api.todo.dto.TodoDTO;
import com.example.crudSpring.api.todo.model.Todo;
import com.example.crudSpring.api.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/api/todo/")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> index() {
        return todoService.findAll().stream().toList();
    }

    @GetMapping("{id}")
    public Todo show(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @PostMapping
    public Todo create(@Valid @RequestBody TodoDTO todo) {
        return todoService.create(todo);
    }

    @PatchMapping("{id}")
    public Todo update(@PathVariable Long id, @Valid @RequestBody TodoDTO todo) {
        return todoService.update(id, todo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
        todoService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
