package com.example.todoapp.service.impl;

import com.example.todoapp.dto.request.TodoCreate;
import com.example.todoapp.dto.response.TodoDto;
import com.example.todoapp.exception.TodoNotFoundException;
import com.example.todoapp.model.Todo;
import com.example.todoapp.repository.TodoRepository;
import com.example.todoapp.repository.UserRepository;
import com.example.todoapp.service.TodoService;
import com.example.todoapp.utils.TodoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Override
    public TodoDto create(TodoCreate todoCreate) {
        Todo todo = TodoMapper.createToTodo(todoCreate);
        todo.setUser(userRepository.findByUsername(todoCreate.getUsername()));
        todo = todoRepository.save(todo);
        return TodoMapper.mapToTodoDto(todo);
    }

    @Override
    public TodoDto delete(UUID id) {
        Todo todo = todoRepository.getById(id);
        todoRepository.delete(todo);
        return TodoMapper.map(todo, TodoDto.class);
    }

    @Override
    public TodoDto update(TodoDto todoDto) {
        Todo todo = todoRepository.save(TodoMapper.mapToTodo(todoDto));
        return TodoMapper.mapToTodoDto(todo);

    }

    @Override
    public Page<TodoDto> get(Pageable paging) {
        Page<Todo> todos = todoRepository.findAll(paging);
        return new PageImpl<TodoDto>(todos.getContent().stream()
                .map(todo -> TodoMapper.mapToTodoDto(todo))
                .collect(Collectors.toList()), paging, todos.getTotalElements());
    }

    @Override
    public TodoDto find(UUID id) {
        return TodoMapper.mapToTodoDto(todoRepository
                .findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo Not Found")));
    }

}
