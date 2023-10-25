package com.example.Todo.App.Services;

import com.example.Todo.App.Models.TodoClass;
import com.example.Todo.App.Repository.TodoRepoinf;

import java.util.List;
import java.util.Optional;

public class TodoServiceImpl implements TodoService {

    private TodoRepoinf todoRepoinf;


    @Override
    public List<TodoClass> getAllTodos() {

        return todoRepoinf.findAll();


    }

    @Override
    public Optional<TodoClass> getTodoByid(Long id) {
        return todoRepoinf.findById(id);
    }

    @Override
    public TodoClass addTodo(TodoClass todo) {
        return todoRepoinf.save(todo);

    }

    @Override
    public void deleteById(Long id) {
        todoRepoinf.deleteById(id);


    }


}
