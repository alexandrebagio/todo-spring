package com.example.todo.api.todo.respository;

import com.example.todo.api.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> { }
