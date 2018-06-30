package com.example.demo.controller;

import com.example.demo.domain.TaskEntity;
import com.example.demo.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("tasks")
public class TaskController {

    private static final Logger log = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    TaskService taskService;


    @GetMapping()
    public List<TaskEntity> showAllTasks() {
        log.info("Showed all tasks");
        //        if(tasks.isEmpty()){
//            return new ArrayList<TaskEntity>();
//        }
        return taskService.findAll();
    }

    @GetMapping("/task")
    @ResponseBody
    public ResponseEntity<TaskEntity> showConcreteTask(@RequestParam int id) {
        log.info("Displayed task {1}", id);
        TaskEntity task = taskService.findTaskById(id);
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
    public ResponseEntity<?> getResult(@RequestParam int taskId, @RequestParam String solutionId,
                                       @RequestParam String solution) {
        log.info("A solution to the task {1} was sent", taskId);
        String result = taskService.getResult(taskId, solutionId, solution);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/task")
    public boolean deleteTask(@RequestParam int id){
        log.info("Task {1} was deleted", id);
        taskService.deleteTask(id);
        return true;
    }
}
