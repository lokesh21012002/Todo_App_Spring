package com.example.Todo.App.Repository;

import com.example.Todo.App.Models.TodoClass;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepoinf extends JpaRepository<TodoClass,Long> {


}
