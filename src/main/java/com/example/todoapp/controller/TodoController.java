package com.example.todoapp.controller;

import com.example.todoapp.dto.request.TodoCreate;
import com.example.todoapp.dto.response.TodoDto;
import com.example.todoapp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<?> find(@PathVariable UUID id) {
        return ResponseEntity.ok(todoService.find(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTodo(@RequestParam int pageSize, @RequestParam int pageNumber) {
        Pageable paging = PageRequest.of(pageSize, pageNumber);
        return ResponseEntity.ok(todoService.get(paging));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TodoCreate todoCreate) {

        return ResponseEntity.ok(todoService.create(todoCreate));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody UUID id) {
        return ResponseEntity.ok(todoService.delete(id));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody TodoDto todoDto) {
        return ResponseEntity.ok(todoService.update(todoDto));
    }
}
