package com.example.Todo.App.Services;

import com.example.Todo.App.Models.TodoClass;
import com.example.Todo.App.Repository.TodoRepoinf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServices {

    @Autowired
    TodoRepoinf todoRepoinf;

     public List<TodoClass>getAllTodos(){

        ArrayList<TodoClass> listofTodos=new ArrayList<>();
        todoRepoinf.findAll().forEach(todoClass -> listofTodos.add(todoClass));
        return listofTodos;





    }
    public TodoClass getTodoById(Long id){
         return  todoRepoinf.findById(id);
//        return todo;


    }

    public boolean updateStatus(Long id){
        TodoClass todo=getTodoById(id);
//
        todo.setStatus("completed");
        return updateOrSaveTodo(todo);
//        String currStatus=todo.getStatus();
//        if(currStatus.equals("completed")){
//            todo.setStatus("Not Completed");
//            return true;
//        }
//        else if(currStatus.equals("Not Completed")){
//            todo.setStatus("completed");
//            return true;
//        }
//
//
//        return false;
//        todo.setStatus("completed");



    }


    public boolean updateOrSaveTodo(TodoClass todo){
         TodoClass updateTodo=todoRepoinf.save(todo);
        return getTodoById(updateTodo.getId()) != null;
//        if(todo==null){
//            return false;
//        }
//        todoRepoinf.save(todo);
//        return true;


    }

    public  boolean deleteTodo(Long id){
         todoRepoinf.deleteById(id);
        return getTodoById(id) == null;


//        TodoClass todo=getTodoById(id);
//        if(todo==null){
//            return false;
//        }
//        todoRepoinf.deleteById(id);
//        return true;




    }
}
