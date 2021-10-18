package com.example.todoapp.service;

import com.example.todoapp.model.User;

import java.util.List;

public interface UserService {
    User create(User user);

    List<User> getUser();
}
