package com.example.todo_application.controllers;

import com.example.todo_application.models.Task;
import com.example.todo_application.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() throws IOException {
        List<Task> tasks = todoService.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task newTask) throws IOException {
        Task createdTask = todoService.createTask(newTask.getDescription());
        return ResponseEntity.ok(createdTask);
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<Task> completeTask(@PathVariable int id) throws IOException {
        Task task = todoService.markTaskAsCompleted(id);
        if (task != null) {
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
