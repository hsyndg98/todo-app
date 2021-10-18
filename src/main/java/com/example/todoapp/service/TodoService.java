package com.example.todoapp.service;

import com.example.todoapp.dto.request.TodoCreate;
import com.example.todoapp.dto.response.TodoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;


public interface TodoService {

    TodoDto create(TodoCreate todoCreate);

    TodoDto delete(UUID id);

    TodoDto update(TodoDto todoDto);

    Page<TodoDto> get(Pageable paging);

    TodoDto find(UUID id);
}
