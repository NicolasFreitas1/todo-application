package com.example.todo_application.services;

import com.example.todo_application.models.Task;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    // Caso esteja rodando localmente, trocar valor da variável para: "src/main/resources/tasks.json";
    
    private static final String FILE_PATH = "/app/resources/tasks.json";
    private ObjectMapper objectMapper = new ObjectMapper();

    public List<Task> getTasks() throws IOException {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            return objectMapper.readValue(file, new TypeReference<List<Task>>() {});
        } else {
            return new ArrayList<>();
        }
    }

    public Task createTask(String description) throws IOException {
        List<Task> tasks = getTasks();
        int id = tasks.size() + 1;
        Task newTask = new Task(id, description, false);
        tasks.add(newTask);
        saveTasks(tasks);
        return newTask;
    }

    public Task markTaskAsCompleted(int id) throws IOException {
        List<Task> tasks = getTasks();
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setCompleted(true);
                saveTasks(tasks);
                return task;
            }
        }
        return null;
    }

    private void saveTasks(List<Task> tasks) throws IOException {
        objectMapper.writeValue(new File(FILE_PATH), tasks);
    }
}
