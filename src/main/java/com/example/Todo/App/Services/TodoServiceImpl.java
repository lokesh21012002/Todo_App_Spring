package com.example.Todo.App.Services;

import com.example.Todo.App.Models.TodoClass;
import com.example.Todo.App.Repository.TodoRepoinf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TodoServiceImpl implements TodoService {


    @Autowired
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
