package com.example.Todo.App.controllers;


import com.example.Todo.App.Exceptions.TodoNotFoundException;
import com.example.Todo.App.Models.TodoClass;
import com.example.Todo.App.Services.TodoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class todoController {

@Autowired
private TodoService todoService;

private final Logger LOGGER= LoggerFactory.getLogger(todoController.class);




    @GetMapping

    public ResponseEntity<List<TodoClass>> getAllTodos(){
        LOGGER.info("Inside getAllTodos method");
        return new ResponseEntity<>(todoService.getAllTodos(), HttpStatusCode.valueOf(200));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTodoById(@PathVariable  Long id) throws TodoNotFoundException {
//        return new ResponseEntity<>(todoService.getTodoByid(id),HttpStatusCode.valueOf(200));

        TodoClass todo=todoService.getTodoByid(id);
        if(todo!=null){
//            todoService.deleteById(id);
            return new ResponseEntity<>(todo,HttpStatusCode.valueOf(200));
        }
        else{
            return new ResponseEntity<>("Not Found",HttpStatusCode.valueOf(404));
        }





//        Optional<TodoClass> todo = todoService.getTodoByid(id);
//        return todo.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTodo( @Valid @RequestBody TodoClass todo){
        try {
            return new ResponseEntity<>(todoService.addTodo(todo), HttpStatusCode.valueOf(200));
        }
        catch (Exception e){
            LOGGER.info(e.getMessage());
            return  new ResponseEntity<>(e,HttpStatusCode.valueOf(404));

        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable Long id, @RequestBody TodoClass todo) throws TodoNotFoundException {
        TodoClass todoDb=todoService.getTodoByid(id);
        if(todoDb!=null) {

            return new ResponseEntity<>(todoService.updateTodo(id, todo), HttpStatusCode.valueOf(200));
        }


        return new ResponseEntity<>("Not Found",HttpStatusCode.valueOf(404));

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
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws TodoNotFoundException {
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

    public ResponseEntity<?> findTodoByTitle(@PathVariable String title){
        try {
            if(!todoService.findTodoByTitleIgnoreCase(title).isEmpty()) {
                return new ResponseEntity<>(todoService.findTodoByTitleIgnoreCase(title), HttpStatusCode.valueOf(200));
            }
            else{
                return new ResponseEntity<>("Not Found",HttpStatusCode.valueOf(404));
            }
            }
        catch (Exception e){
            LOGGER.info(e.getMessage());
            return new ResponseEntity<>("Not Found",HttpStatusCode.valueOf(404));

        }
    }

    @GetMapping("/status/{status}")

    public ResponseEntity<?> findTodoByStatus(@PathVariable String status){
        try {
            if(!todoService.findTodoByStatusIgnoreCase(status).isEmpty()) {
                return new ResponseEntity<>(todoService.findTodoByStatusIgnoreCase(status), HttpStatusCode.valueOf(200));
            }
            else{
                return new ResponseEntity<>("Not Found",HttpStatusCode.valueOf(404));
            }
        }
        catch (Exception e){
            LOGGER.info(e.getMessage());
            return new ResponseEntity<>("Not Found",HttpStatusCode.valueOf(404));

        }
    }















}
