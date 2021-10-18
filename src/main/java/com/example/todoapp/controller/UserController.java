package com.example.todoapp.controller;

import com.example.todoapp.model.User;
import com.example.todoapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user){
        return ResponseEntity.ok(userService.create(user));
    }
    @GetMapping
    public ResponseEntity<?> getUser(){
        return ResponseEntity.ok(userService.getUser());
    }
}
