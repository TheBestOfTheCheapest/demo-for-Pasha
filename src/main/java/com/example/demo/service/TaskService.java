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

    public TaskEntity findTaskById(int id){
        return taskRepo.findById(id);
    }

    public void add(String taskTitle, String taskText){
        TaskEntity task = new TaskEntity();
        task.setTaskTitle(taskTitle);
        task.setTaskText(taskText);
        taskRepo.save(task);
    }
}
