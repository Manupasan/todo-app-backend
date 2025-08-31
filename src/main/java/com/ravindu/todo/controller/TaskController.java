package com.ravindu.todo.controller;

import com.ravindu.todo.entity.Task;
import com.ravindu.todo.repository.TaskRepository;
import com.ravindu.todo.services.TaskService;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/tasks")

public class TaskController {
    private final TaskRepository repository;
    private final TaskService taskService;

    public TaskController(TaskRepository repository, TaskService taskService) {
        this.repository = repository;
        this.taskService = taskService;
    }


    //Get all tasks
    @GetMapping
    public List<Task> getTasks(Authentication authentication) {
        String username = authentication.getName();
        return taskService.getTasks(username);
    }

    //Create a task
    @PostMapping
    public Task createTask(@RequestBody Task task, Authentication authentication){
        String username = authentication.getName();
        return taskService.addTask(username, task);
    }

    //Update a task
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task){
        Task existing = repository.findById(id).orElseThrow();
        existing.setTitle(task.getTitle());
        existing.setCompleted(task.isCompleted());
        return repository.save(existing);
    }

    //Delete a task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        repository.deleteById(id);
    }
}
