package com.example.demo.controller;

import com.example.demo.controller.exceptions.NotFoundException;
import com.example.demo.domain.SolutionEntity;
import com.example.demo.domain.TaskEntity;
import com.example.demo.service.TaskService;
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

    @Autowired
    TaskService taskService;


    @GetMapping()
    public List<TaskEntity> showAllTasks() {
        log.info("Showed all tasks");
        if(taskService.findAll().isEmpty()) {
            log.info("No tasks");
            throw new NotFoundException();
        }
        return taskService.findAll();
    }

//    @CrossOrigin(origins = "http://localhost:9000")
    @GetMapping("/task")
    @ResponseBody
    public ResponseEntity<TaskEntity> showConcreteTask(@RequestParam int taskId) {
        log.info("Displayed task {1}", taskId);
        TaskEntity task = taskService.findTaskById(taskId);
        if (task==null) {
            log.error("Request to the task with id {1}, which not exist", taskId);
            throw new NotFoundException();
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TaskEntity> addTask(@RequestParam String taskTitle, @RequestParam String taskText,
                                              @RequestParam String sourceSample) {
        log.info("New task was added");
        TaskEntity newTask = taskService.add(taskTitle, taskText, sourceSample);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @PostMapping("/solution")
    public ResponseEntity<?> getResult(@RequestBody SolutionEntity solution) {
        log.info("A solution to the task {1} was sent");
        String result = "{ \"result\" : \"" + taskService.getResult(solution) + "\"}";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/task")
    public boolean deleteTask(@RequestParam int taskId){
        log.info("Task {1} was deleted", taskId);
        taskService.deleteTask(taskId);
        return true;
    }
}