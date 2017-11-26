package com.practice.backend.service;

import com.practice.backend.model.Todo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoService {

    private List<Todo> todos;

    public TodoService() {
        this.todos = new ArrayList<>();
        this.createTestTodos();
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public boolean removeTodo(Todo todo) {
        if (todos.contains(todo)) {
            todos.remove(todo);
            return true;
        }
        return false;
    }

    public void setTodoStatus(Todo todo, boolean status) {
        if (todos.contains(todo)) {
            todos.get(todos.indexOf(todo)).setStatus(status);
        } else {
            todo.setStatus(status);
            this.addTodo(todo);
        }
    }

    public List<Todo> getTodosByName(String name) {
        return todos.stream()
                .filter(t -> t.getNameOfPerson().equals(name))
                .collect(Collectors.toList());
    }

    private void createTestTodos() {
        Todo t1 = new Todo("Rick", "Nothing", 5);
        Todo t2 = new Todo("Loci", "Learn angular", 1);

        todos.add(t1);
        todos.add(t2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoService that = (TodoService) o;

        return todos != null ? todos.equals(that.todos) : that.todos == null;
    }

    @Override
    public int hashCode() {
        return todos != null ? todos.hashCode() : 0;
    }
}
