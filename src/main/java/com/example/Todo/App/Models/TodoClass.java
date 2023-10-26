package com.example.Todo.App.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Date;



@Entity
@Table (name="todo")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder



public class TodoClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Column
    @NotBlank(message = "Please provide title")
//    @Length(max = 10,min=5)
//    @Size(max=10,min=5)
//    @Email
//    @Positive
//    @Negative
//    @Future
//    @FutureOrPresent
//    @PositiveOrZero
//    @NegativeOrZero
//    @PastOrPresent

    private String  title;
    private Date date;

    private String status;
    
    
//    public  TodoClass(){
//
//    }
//
//
//    public TodoClass(Long id, String title, Date date, String status) {
//        super();
//
//        this.id = id;
//
//        this.title = title;
//        this.date = date;
//        this.status = status;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
}
