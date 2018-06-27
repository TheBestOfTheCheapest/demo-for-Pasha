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

    public void add(String taskTitle, String taskText, String sourceSample){
        TaskEntity task = new TaskEntity();
        task.setTaskTitle(taskTitle);
        task.setTaskText(taskText);
        task.setSourceSample(sourceSample);
        taskRepo.save(task);
    }

    public String getResult(String taskId, String solutionId, String solution){
        //todo достать параметры из базы и определить name
        //todo найти класс шаблона задачи
        //todo найти класс шаблона задачи
        return "42";
    }
}
