package com.todo.TodoList.controller;

import com.todo.TodoList.models.Todo;
import com.todo.TodoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // Create new_todo
    @PostMapping("/create")
    ResponseEntity<Todo> createUser(@RequestBody Todo todo){
        Todo createdTodo= todoService.createTodo(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    // Get the created_todo by id
    @GetMapping("/{id}")
    ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        try {
            Todo createdTodo = todoService.getTodoById(id);
            return new ResponseEntity<>(createdTodo, HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Get all todos
    @GetMapping
    ResponseEntity<List<Todo>> getTodos(){
        return new ResponseEntity<List<Todo>>(todoService.getAllTodos(), HttpStatus.OK);
    }


    // Get Todos with paged
    @GetMapping("/page")
    ResponseEntity<Page<Todo>> getTodoPaged(@RequestParam int page, @RequestParam int size){
        return new ResponseEntity<>(todoService.getAllTodoPages(page,size), HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<Todo> updateTodoById(@RequestBody Todo todo) {
        return new ResponseEntity<>(todoService.updateTodo(todo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteTodoById(@PathVariable long id) {
        todoService.deleteTodoById(id);
    }

}

