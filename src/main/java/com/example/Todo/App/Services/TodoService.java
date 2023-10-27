package com.example.Todo.App.Services;

import com.example.Todo.App.Exceptions.TodoNotFoundException;
import com.example.Todo.App.Models.TodoClass;

import java.util.List;

public interface TodoService {
    List<TodoClass> getAllTodos();

    TodoClass getTodoByid(Long id) throws TodoNotFoundException;

    TodoClass addTodo(TodoClass todo);

    void deleteById(Long id);

    TodoClass updateTodo(Long id, TodoClass todo);

    List<TodoClass> findTodoByTitleIgnoreCase(String title);

    List<TodoClass> findTodoByStatusIgnoreCase(String status);
}
