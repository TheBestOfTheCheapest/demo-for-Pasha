package com.example.demo.service;

import com.example.demo.domain.TaskEntity;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepo;

    public List<TaskEntity> findAll(){
        return taskRepo.findAll();
    }

    public void add(String name, String text){
        TaskEntity task = new TaskEntity();
        task.setName(name);
        task.setTask(text);
        taskRepo.save(task);
    }
}
