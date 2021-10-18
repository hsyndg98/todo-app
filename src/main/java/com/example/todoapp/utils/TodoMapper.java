package com.example.todoapp.utils;

import com.example.todoapp.dto.request.TodoCreate;
import com.example.todoapp.dto.response.TodoDto;
import com.example.todoapp.model.Todo;
import com.example.todoapp.model.User;

public class TodoMapper extends BaseMapper {

    public static Todo mapToTodo(TodoDto todoDto) {
        return modelMapper.map(todoDto, Todo.class);
    }

    public static TodoDto mapToTodoDto(Todo todo) {
        User user = todo.getUser();
        TodoDto todoDto = modelMapper.map(todo, TodoDto.class);
        todoDto.setUsername(user.getUsername());
        return todoDto;
    }
    public static Todo createToTodo(TodoCreate todoCreate){
        return modelMapper.map(todoCreate,Todo.class);
    }
}
