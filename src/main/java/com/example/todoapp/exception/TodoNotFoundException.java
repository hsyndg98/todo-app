package com.example.todoapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TodoNotFoundException extends RuntimeException{

    public TodoNotFoundException() {
    }
    public TodoNotFoundException(String message) {
        super(message);
    }
}
