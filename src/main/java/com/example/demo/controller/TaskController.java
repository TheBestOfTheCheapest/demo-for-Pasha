package com.example.demo.controller;

import com.example.demo.domain.TaskEntity;
import com.example.demo.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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


    @GetMapping()
    public List<TaskEntity> showAllTasks(){
        log.info("Showed all tasks");
        List<TaskEntity> tasks = taskService.findAll();
//        if(tasks.isEmpty()){
//            return new ArrayList<TaskEntity>();
//        }
        return tasks;
    }

    @GetMapping("{id}")
    public TaskEntity showConcreteTask(@PathVariable int id){
        log.info("Displayed task {1}", id);
        TaskEntity task = taskService.findTaskById(id);
        return task;
    }

    //ToDo remake
    @PostMapping("/tasks")
    public void addTask(@RequestParam String name, @RequestParam String text){
        taskService.add(name, text);
    }
}
