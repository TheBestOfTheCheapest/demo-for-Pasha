package com.example.demo.controller;

import com.example.demo.domain.TaskEntity;
import com.example.demo.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("task")
public class TaskController {

    public static final Logger log = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    TaskService taskService;


    @PostMapping()
    public List<TaskEntity> showAllTasks() {
        log.info("Showed all tasks");
        List<TaskEntity> tasks = taskService.findAll();
//        if(tasks.isEmpty()){
//            return new ArrayList<TaskEntity>();
//        }
        return tasks;
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskEntity> showConcreteTask(@PathVariable int id) {
        log.info("Displayed task {1}", id);
        TaskEntity task = taskService.findTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    //ToDo remake
    @PostMapping("/add")
    public ResponseEntity<TaskEntity> addTask(@RequestParam String taskTitle, @RequestParam String taskText,
                                              @RequestParam String sourceSample) {
        taskService.add(taskTitle, taskText, sourceSample);

        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(headers, HttpStatus.I_AM_A_TEAPOT);
    }

    @PostMapping()
    public ResponseEntity<?> getResult(@RequestParam String taskId, @RequestParam String solutionId,
                                       @RequestParam String solution) {
        String result = taskService.getResult(taskId, solutionId, solution);
        return new ResponseEntity<String>(result, HttpStatus.I_AM_A_TEAPOT );
    }
}
