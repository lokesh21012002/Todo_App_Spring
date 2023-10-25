package com.example.Todo.App.controllers;


import com.example.Todo.App.Models.TodoClass;
import com.example.Todo.App.Repository.TodoRepoinf;
import com.example.Todo.App.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class todoController {

@Autowired
TodoService todoService;

    @GetMapping

    public ResponseEntity<List<TodoClass>> getAllTodos(){
        return new ResponseEntity<>(todoService.getAllTodos(), HttpStatusCode.valueOf(200));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TodoClass> getTodoById(@PathVariable  Long id){
        Optional<TodoClass> todo = todoService.getTodoByid(id);
        return todo.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TodoClass> addTodo(@RequestBody TodoClass todo){
        return new ResponseEntity<>(todoService.addTodo(todo),HttpStatusCode.valueOf(200));
    }

    @PutMapping
    public ResponseEntity<TodoClass> updateTodo(@RequestBody Long id,TodoClass todo){
        Optional<TodoClass> currTodo=todoService.getTodoByid(id);
        if(currTodo.isPresent()){
            currTodo.get().setTitle(todo.getTitle());
            currTodo.get().setStatus(todo.getStatus());
            currTodo.get().setDate(todo.getDate());
            return new ResponseEntity<>(todoService.addTodo(currTodo.get()),HttpStatusCode.valueOf(200));
        }
        else{
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<TodoClass> deleteById(@PathVariable Long id){
        Optional<TodoClass> todo=todoService.getTodoByid(id);
        if(todo.isPresent()){
            todoService.deleteById(id);
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        }
        else{
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
    }















}
