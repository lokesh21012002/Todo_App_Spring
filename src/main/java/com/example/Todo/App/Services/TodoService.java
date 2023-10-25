package com.example.Todo.App.Services;

import com.example.Todo.App.Models.TodoClass;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<TodoClass> getAllTodos();

    Optional<TodoClass> getTodoByid(Long id);

    TodoClass addTodo(TodoClass todo);

    void deleteById(Long id);
}
