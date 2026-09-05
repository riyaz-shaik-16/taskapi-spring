package com.riyaz.taskapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.riyaz.taskapi.exception.TaskNotFoundException;
import com.riyaz.taskapi.model.Task;


@Service 
public class TaskService {
    private List<Task> tasks = new ArrayList<>();

    public TaskService(){}

    public List<Task> getAllTasks(){
        return tasks;
    }

    public Task createTask(String name){
        Task task = new Task(name);
        tasks.add(task);
        return task;
    }

    public Task getById(long id){
        for(Task task : tasks){
            if(task.getId()==id) return task;
        }
        throw new TaskNotFoundException("Task not Found!");
    }

    public Task update(long id){
        for(Task task : tasks){
            if(task.getId()==id){
                task.markDone();
                return task;
            }
        }

        throw new TaskNotFoundException("Task not Found!");
    }

    public Task delete(long id){
        for(Task task : tasks){
            if(task.getId()==id){
                Task removedTask = task;
                tasks.remove(task);
                return removedTask;
            }
        }

        throw new TaskNotFoundException("Task not Found!");
    }


}
