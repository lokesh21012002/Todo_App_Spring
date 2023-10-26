package com.example.Todo.App.Repository;

import com.example.Todo.App.Models.TodoClass;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepoinf extends JpaRepository<TodoClass,Long> {


    List<TodoClass> findByTitleIgnoreCase(String title);


//    @Query(JPQL query)
    List<TodoClass> findByStatusIgnoreCase(String status);





}
