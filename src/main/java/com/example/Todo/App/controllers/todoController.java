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
private TodoService todoService;

    @GetMapping

    public ResponseEntity<List<TodoClass>> getAllTodos(){
        return new ResponseEntity<>(todoService.getAllTodos(), HttpStatusCode.valueOf(200));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TodoClass> getTodoById(@PathVariable  Long id){
        return new ResponseEntity<>(todoService.getTodoByid(id),HttpStatusCode.valueOf(200));






//        Optional<TodoClass> todo = todoService.getTodoByid(id);
//        return todo.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public ResponseEntity<TodoClass> addTodo(@RequestBody TodoClass todo){
        return new ResponseEntity<>(todoService.addTodo(todo),HttpStatusCode.valueOf(200));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TodoClass> updateTodo(@PathVariable Long id, @RequestBody TodoClass todo){

        return  new ResponseEntity<>(todoService.updateTodo(id,todo),HttpStatusCode.valueOf(200));

//        Optional<TodoClass> currTodo=todoService.getTodoByid(todo.getId());
//        if(currTodo.isPresent()){
//            currTodo.get().setTitle(todo.getTitle());
//            currTodo.get().setStatus(todo.getStatus());
//            currTodo.get().setDate(todo.getDate());
//            return new ResponseEntity<>(todoService.addTodo(currTodo.get()),HttpStatusCode.valueOf(200));
//        }
//        else{
//            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
//        }

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        TodoClass todo=todoService.getTodoByid(id);
        if(todo!=null){
            todoService.deleteById(id);
            return new ResponseEntity<>("Deleted sucessfully",HttpStatusCode.valueOf(200));
        }
        else{
            return new ResponseEntity<>("Not Found",HttpStatusCode.valueOf(404));
        }
    }

    @GetMapping("/title/{title}")

    public ResponseEntity<List<TodoClass>> findTodoByTitle(@PathVariable String title){
        return new ResponseEntity<>(todoService.findTodoByTitle(title),HttpStatusCode.valueOf(200));

    }

    @GetMapping("/status/{status}")

    public ResponseEntity<List<TodoClass>> findTodoByStatus(@PathVariable String status){
        return new ResponseEntity<>(todoService.findTodoByStatus(status),HttpStatusCode.valueOf(200));

    }















}
