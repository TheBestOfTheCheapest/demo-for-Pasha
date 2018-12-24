/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2018.
 */

package com.example.demo.controller;

import com.example.demo.controller.exceptions.NotFoundException;
import com.example.demo.domain.SolutionEntity;
import com.example.demo.domain.TaskEntity;
import com.example.demo.service.TaskService;
import com.example.demo.service.dto.ResultDTO;
import com.example.demo.service.dto.SolutionDTO;
import com.example.demo.service.dto.TaskDTO;
import com.example.demo.service.dto.TasksDTO;
import com.example.demo.service.mapper.SolutionMapper;
import com.example.demo.service.mapper.TaskMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:9000", "http://192.168.238.107:9000"})
@RestController
@RequestMapping("api/tasks")
public class TaskController {

    private static final Logger log = LoggerFactory.getLogger(TaskController.class);

    private final TaskService taskService;
    private final TaskMapper taskMapper;
    private final SolutionMapper solutionMapper;

    @Autowired
    public TaskController(TaskService taskService, TaskMapper taskMapper, SolutionMapper solutionMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
        this.solutionMapper = solutionMapper;
    }

    @GetMapping()
    public ResponseEntity<TasksDTO> showAllTasks(Integer number) throws Exception {
        log.info("Showed all tasks");
        if (taskService.findAll().getTasks().isEmpty()) {
            log.info("No tasks");
            throw new NotFoundException();
        }
        if(number == null)
            return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
        else
            return new ResponseEntity<>(taskService.randomTasks(number), HttpStatus.OK);
    }

    @GetMapping("/task")
    @ResponseBody
    public ResponseEntity<TaskDTO> showConcreteTask(@RequestParam int taskId) {
        TaskEntity task = taskService.findTaskById(taskId);
        //TaskEntity task = taskService.findTaskById(taskId);
        if (task == null) {
            log.error("Request to the task with id {}, which not exist", taskId);
            throw new NotFoundException();
        }
        log.info("Retrieve task with id {}", taskId);
        return new ResponseEntity<>(taskMapper.toDto(task), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO taskDto) {
        log.info("New task was added");
        TaskEntity newTask = taskService.add(taskDto);
        return new ResponseEntity<>(taskMapper.toDto(newTask), HttpStatus.CREATED);
    }

    @PostMapping("/solution")
    public ResponseEntity<ResultDTO> getResult(@RequestBody SolutionDTO solutionDto) {
        log.info("A solution to the task {} was sent", solutionDto.getTaskId());
        SolutionEntity solution = solutionMapper.toEntity(solutionDto);
        ResultDTO result = taskService.getResult(solution);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/task")
    public boolean deleteTask(@RequestParam int taskId) {
        log.info("Task {} was deleted", taskId);
        taskService.deleteTask(taskId);
        return true;
    }
}