package com.riyaz.taskapi.model;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;


import jakarta.validation.constraints.NotBlank;

public class Task {
    private static final AtomicLong ID_GENERATOR = new AtomicLong();

    @NotBlank(message = "Task name should not be empty!") 
    private String name;

    private LocalDateTime createdAt;

    private boolean done;

    private long id;


    public Task(String name){
        this.id = ID_GENERATOR.incrementAndGet();
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.done = false;
    }

    public String getName(){
        return this.name;
    }
    
    public long getId(){
        return this.id;
    }

    public LocalDateTime getCreatedAt(){
        return this.createdAt;
    }

    public void markDone(){
        this.done = true;
    }

    public boolean getDone(){
        return this.done;
    }


}
