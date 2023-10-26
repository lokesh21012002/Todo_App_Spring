package com.example.Todo.App.Services;

import com.example.Todo.App.Models.TodoClass;
import com.example.Todo.App.Repository.TodoRepoinf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public TodoClass getTodoByid(Long id) {
        Optional<TodoClass> tmp=todoRepoinf.findById(id);
        if(tmp.isEmpty()){
            return null;
        }


        return tmp.get();
    }

    @Override
    public TodoClass addTodo(TodoClass todo) {
        return todoRepoinf.save(todo);


    }

    @Override
    public void deleteById(Long id) {
        todoRepoinf.deleteById(id);



//        Optional<TodoClass> tmp=todoRepoinf.findById(id);
//        if(tmp.isEmpty()){
//            return "Todo does't exist";
//        }
//        todoRepoinf.deleteById(id);
//
//
//        return "Todo deleted sucessfully";



    }

    @Override
    public TodoClass updateTodo(Long id, TodoClass todo) {

        TodoClass pastTodo=todoRepoinf.findById(id).get();

        if(Objects.nonNull(todo.getStatus()) && !"".equalsIgnoreCase(todo.getStatus())){
            pastTodo.setStatus(todo.getStatus());

        }
        if(Objects.nonNull(todo.getTitle()) && !"".equalsIgnoreCase(todo.getTitle())){
            pastTodo.setTitle(todo.getTitle());

        }
        if(Objects.nonNull(todo.getDate())){
            pastTodo.setDate(todo.getDate());

        }


//        if(!todo.getStatus().isEmpty()){
//            pastTodo.setStatus(todo.getStatus());
//        }
//        if(todo.getDate()!=null){
//            pastTodo.setDate(todo.getDate());
//        }
//        if(!todo.getTitle().isEmpty()){
//            pastTodo.setStatus(todo.getTitle());
//        }


        todoRepoinf.save(pastTodo);
        return pastTodo;


//        pastTodo.setDate((todo.getDate() || pastTodo.getDate()));
//        pastTodo.setTitle(todo.getTitle() || pastTodo.getTitle());
//        pastTodo.setStatus(todo.getStatus() || pastTodo.getStatus());
//
//        todoRepoinf.save(pastTodo);
//        return pastTodo;




    }

    @Override
    public List<TodoClass> findTodoByTitleIgnoreCase(String title) {
        return todoRepoinf.findByTitleIgnoreCase(title);


    }

    @Override
    public List<TodoClass> findTodoByStatusIgnoreCase(String status) {
        return todoRepoinf.findByStatusIgnoreCase(status);

    }


}
