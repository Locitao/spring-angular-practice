package com.practice.backend.controllers;

import com.practice.backend.model.Todo;
import com.practice.backend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return todoService.getTodos();
    }

    @GetMapping("/todos/{name}")
    public List<Todo> getTodosByName(@PathVariable("name") String name) {
        return todoService.getTodosByName(name);
    }

    @PostMapping("/todos")
    public Todo createTodo(@Valid @RequestBody Todo todo) {
        System.out.println(todo.toString());
        todoService.addTodo(todo);
        return todo;
    }
}
