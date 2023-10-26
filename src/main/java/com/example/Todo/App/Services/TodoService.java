package com.example.Todo.App.Services;

import com.example.Todo.App.Models.TodoClass;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<TodoClass> getAllTodos();

    TodoClass getTodoByid(Long id);

    TodoClass addTodo(TodoClass todo);

    void deleteById(Long id);

    TodoClass updateTodo(Long id, TodoClass todo);

    List<TodoClass> findTodoByTitleIgnoreCase(String title);

    List<TodoClass> findTodoByStatusIgnoreCase(String status);
}
