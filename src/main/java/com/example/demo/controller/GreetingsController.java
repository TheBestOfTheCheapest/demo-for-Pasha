package com.example.demo.controller;


import com.example.demo.entity.TaskEntity;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import test1.MatrixSumm;
import utills.FileWriter;

import java.util.Map;

@Controller
public class GreetingsController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World")
                                       String name, Map<String,Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/tasks")
    public String showTasks(Map<String, Object> model){

        Iterable<TaskEntity> tasks = taskRepository.findAll();
        model.put("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/")
    public String readCode(@RequestParam(name = "code", required = false, defaultValue = "    public int calculateMatrix(int[][] array){\n" +
            "        \n" +
            "        \n" +
            "        \n" +
            "        return summ;\n" +
            "    }") String code, Map<String,Object> model) {
        FileWriter fw = new FileWriter();
        fw.codePast("C:\\Users\\kshegolev\\Desktop\\demo\\src\\main\\java\\test1\\MatrixSumm.java",code);
        try {
            MatrixSumm ms = new MatrixSumm();
            ms.test();
        }catch (Exception e){
            System.out.println(e);
        }
         fw.restoreFile("C:\\Users\\kshegolev\\Desktop\\demo\\src\\main\\java\\test1\\MatrixSumm.java");
        model.put("name","SUCCES");
        //в случае успеха изменить форму с отправить на далее
        return "greeting";
    }
}