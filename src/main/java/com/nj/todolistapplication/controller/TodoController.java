package com.nj.todolistapplication.controller;

import com.nj.todolistapplication.entity.Todo;
import com.nj.todolistapplication.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // GET tous les todos
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    // GET todo par ID
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }

    // POST - Créer un nouveau todo
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    // PUT - Mettre à jour un todo
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }

    // DELETE - Supprimer un todo
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

    // PATCH - Marquer comme complété / inverser l'état
    @PatchMapping("/{id}/toggle")
    public Todo toggleComplete(@PathVariable Long id) {
        return todoService.toggleComplete(id);
    }

    // GET - Filtrer par statut (true/false)
    @GetMapping("/status/{completed}")
    public List<Todo> getTodosByStatus(@PathVariable Boolean completed) {
        return todoService.getTodosByStatus(completed);
    }
}
