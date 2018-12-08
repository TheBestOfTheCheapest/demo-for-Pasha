/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2018.
 */

package com.example.demo.service;

import com.example.demo.domain.SolutionEntity;
import com.example.demo.domain.TaskEntity;
import com.example.demo.repository.SolutionRepository;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.core.TaskRunner;
import com.example.demo.service.dto.ResultDTO;
import com.example.demo.service.dto.TaskDTO;
import com.example.demo.service.dto.TasksDTO;
import com.example.demo.service.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepo;
    private final SolutionRepository solutionRepo;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskService(TaskRepository taskRepo, SolutionRepository solutionRepo, TaskMapper taskMapper) {
        this.taskRepo = taskRepo;
        this.solutionRepo = solutionRepo;
        this.taskMapper = taskMapper;
    }

    public TasksDTO findAll() {
        TasksDTO tasks = new TasksDTO();
        List<TaskEntity> tasksList = taskRepo.findAll();
        tasks.setTasks(taskMapper.toDto(tasksList));
        return tasks;
    }

    public TasksDTO randomTasks(Integer number){

        return new TasksDTO();
    }

    public TaskEntity findTaskById(int taskId) {
        return taskRepo.findByTaskId(taskId);
    }

    public TaskEntity add(TaskDTO taskDTO) {
        TaskEntity task = new TaskEntity();
        task.setTaskTitle(taskDTO.getTaskTitle());
        task.setTaskText(taskDTO.getTaskText());
        task.setSourceSample(taskDTO.getSourceSample());
        taskRepo.save(task);
        return task;
    }

    public ResultDTO getResult(SolutionEntity solution) {

        //String taskTitle = taskRepo.findByTaskId(solution.getTask().getTaskId()).getTaskTitle();
        solution.setCreatedTime(LocalDateTime.now());
        TaskEntity task = taskRepo.findByTaskId(solution.getTask().getTaskId());
        TaskRunner taskRunner = new TaskRunner();
        ResultDTO result = new ResultDTO();
        String result1 = "";

        try {
          //  result = taskRunner.run(Searcher.getSource("MatrixSumm"), solution.getSolutionValue(), taskTitle); //MatrixSumm как заглушка
            result.setResult(taskRunner.run(task.getSourceTemplate(), solution.getSolutionValue(), task.getTaskTitle()));
        } catch (Exception e) {
           // result = "qwertyuio";
            e.printStackTrace();
        }

        solution.setTestResult(result.getResult());
        solutionRepo.save(solution);
        return result;
    }

    public void deleteTask(int taskId) {
        taskRepo.delete(findTaskById(taskId));
    }
}
