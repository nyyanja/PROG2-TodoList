package com.nj.todolistapplication.service;

import com.nj.todolistapplication.entity.Todo;
import com.nj.todolistapplication.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    // Récupérer tous les todos
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // Récupérer un todo par ID
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo non trouvé avec l'id: " + id));
    }

    // Créer un nouveau todo
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // Mettre à jour un todo
    public Todo updateTodo(Long id, Todo todoDetails) {
        Todo todo = getTodoById(id);

        todo.setTitle(todoDetails.getTitle());
        todo.setDescription(todoDetails.getDescription());
        todo.setCompleted(todoDetails.getCompleted());

        return todoRepository.save(todo);
    }

    // Supprimer un todo
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    // Marquer comme complété ou non
    public Todo toggleComplete(Long id) {
        Todo todo = getTodoById(id);
        todo.setCompleted(!todo.getCompleted());
        return todoRepository.save(todo);
    }

    // Récupérer les todos par statut
    public List<Todo> getTodosByStatus(Boolean completed) {
        return todoRepository.findByCompleted(completed);
    }
}
