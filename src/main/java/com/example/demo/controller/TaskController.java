/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2018.
 */

package com.example.demo.controller;

import com.example.demo.controller.exceptions.NotFoundException;
import com.example.demo.domain.SolutionEntity;
import com.example.demo.domain.TaskEntity;
import com.example.demo.service.TaskService;
import com.example.demo.service.dto.TaskDTO;
import com.example.demo.service.mapper.EntityMapper;
import com.example.demo.service.mapper.TaskMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
@RequestMapping("tasks")
public class TaskController {

    private static final Logger log = LoggerFactory.getLogger(TaskController.class);

    final TaskService taskService;
    final TaskMapper taskMapper;
    final EntityMapper entityMapper;

    @Autowired
    public TaskController(TaskService taskService, TaskMapper taskMapper, EntityMapper entityMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
        this.entityMapper = entityMapper;
    }


    @GetMapping()
    public List<TaskDTO> showAllTasks() {
        log.info("Showed all tasks");
        if (taskService.findAll().isEmpty()) {
            log.info("No tasks");
            throw new NotFoundException();
        }
        return taskMapper.toDto(taskService.findAll());
    }

    //    @CrossOrigin(origins = "http://localhost:9000")
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

//    @PostMapping("/add")
//    public ResponseEntity<TaskEntity> addTask(@RequestParam String taskTitle, @RequestParam String taskText,
//                                              @RequestParam String sourceSample) {
//        log.info("New task was added");
//        TaskEntity newTask = taskService.add(taskTitle, taskText, sourceSample);
//        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
//    }

    @PostMapping("/solution")
    public ResponseEntity<?> getResult(@RequestBody SolutionEntity solution) {
        log.info("A solution to the task {} was sent", solution.getTask().getTaskId());
        String result = "{ \"result\" : \"" + taskService.getResult(solution)
                .replace("\n", "\\n")
                .replace("\t", "\\t")
                .replace("\r", "\\r") + "\"}";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/task")
    public boolean deleteTask(@RequestParam int taskId) {
        log.info("Task {} was deleted", taskId);
        taskService.deleteTask(taskId);
        return true;
    }
}