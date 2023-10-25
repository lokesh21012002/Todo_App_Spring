package com.example.Todo.App.Models;

import jakarta.persistence.*;

import java.util.Date;



@Entity
@Table (name="todo")


public class TodoClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Column
    private String  title;
    private Date date;

    private String status;
    
    
    public  TodoClass(){
        
    }


    public TodoClass(Long id, String title, Date date, String status) {
        super();

        this.id = id;
        this.title = title;
        this.date = date;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
