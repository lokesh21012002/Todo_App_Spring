package com.example.Todo.App.Exceptions;

import com.example.Todo.App.Models.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<ErrorMessage> todoNotFoundException(TodoNotFoundException exception, WebRequest request){
        ErrorMessage errorMessage=new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
//        return new ResponseEntity<>(errorMessage, HttpStatusCode.valueOf(404));


        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);







    }









}
