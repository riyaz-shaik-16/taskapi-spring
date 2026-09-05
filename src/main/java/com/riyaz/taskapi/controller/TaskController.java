package com.riyaz.taskapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.riyaz.taskapi.model.Task;
import com.riyaz.taskapi.service.TaskService;

import jakarta.validation.Valid;

@RestController 
public class TaskController {
    
    

    private final TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/")
    public ResponseEntity<String> getMessage(){
        return ResponseEntity.ok("Hey there server taskapi is working!");
    }


    @PostMapping("/tasks/create")
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task){
        return ResponseEntity.ok(taskService.createTask(task.getName()));
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable long id){
        return ResponseEntity.ok(taskService.getById(id));
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable long id){
        return ResponseEntity.ok(taskService.delete(id));
    } 

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> markdone(@PathVariable long id){
        return ResponseEntity.ok(taskService.update(id));
    }


}
