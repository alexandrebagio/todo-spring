package com.example.crudSpring.api.todo.respository;

import com.example.crudSpring.api.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> { }
