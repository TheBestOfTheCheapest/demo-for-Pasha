/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package com.example.demo.controller;


import com.example.demo.domain.SolutionEntity;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;
import com.example.demo.service.dto.*;
import com.example.demo.service.mapper.SolutionMapper;
import com.example.demo.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class GreetingsController {

    private final UserService userService;
    private final TaskService taskService;
    private final UserMapper userMapper;
    private final SolutionMapper solutionMapper;

    private Integer userId;
    private Integer taskId;

    @Autowired
    public GreetingsController(UserService userService, TaskService taskService, UserMapper userMapper, SolutionMapper solutionMapper) {

        this.userService = userService;
        this.taskService = taskService;
        this.userMapper = userMapper;
        this.solutionMapper = solutionMapper;
    }

    @GetMapping("/task/{taskId}")
    public String task(@PathVariable String taskId, Integer userId, SolutionDTO solution, Model model) {
        this.taskId = Integer.valueOf(taskId);
        model.addAttribute("task", taskService.findTaskById(Integer.valueOf(taskId)));

        return "task";
    }

    @PostMapping("/task/{taskId}")
    public String solution(@PathVariable Integer taskId, @Valid SolutionDTO solution, Model model) {
        model.addAttribute("task", taskService.findTaskById(taskId));
        model.addAttribute("solutionValue", solution);
        solution.setUserId(userId);
        solution.setTaskId(taskId);
        ResultDTO result = taskService.getResult(solutionMapper.toEntity(solution));


        Map<String, List<String>> mappa = new HashMap<>();

        TableMapper tm = new TableMapper();
        mappa = tm.mapper(result.getResult());
        List<String> val = new ArrayList<>();
        for(String key : mappa.keySet()){
            val=mappa.get(key);

        }
        model.addAttribute("table", mappa);
        model.addAttribute("raws", val);
        model.addAttribute("result", result.getResult());
        return "task";
    }


    @GetMapping("/")
    public String showAuthForm(UserDTO user) {
        return "index";
    }

    @PostMapping("/auth")
    public String auth(@Valid UserDTO user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }


        userId = userService.auth(userMapper.toEntity(user));
        model.addAttribute("user", user);
        model.addAttribute("userId", userId);

        return "redirect:/tasks";

    }

    @GetMapping("/tasks")
    public String taskList(Model model) {
        if (userId == null) {
            return "403";
        }
        TasksDTO tasksDTO = taskService.findAll();
        List<TaskDTO> tasks = tasksDTO.getTasks();
        model.addAttribute("tasks", tasks);
        return "tasklist";
    }

    class TableMapper {
        Map<String, List<String>> table= new HashMap<>();
        Set<String> headers;


        public Map<String, List<String>> mapper(String input) {
            Pattern pattern = Pattern.compile(".+?(?=})");
            Matcher matcher = pattern.matcher(input);
            String firstLine = "";
            if (matcher.find()) {
                firstLine = matcher.group();
            }
            firstLine = firstLine.replace("[{", "");
            firstLine = " " + firstLine;
            firstLine += ",";
            // pattern = Pattern.compile("(.+?(?==))(.+?(?=,))");
            pattern = Pattern.compile(" (.*?)=");
            matcher = pattern.matcher(firstLine);

            Set<String> headers = new HashSet<>();

            while (matcher.find()) {
                headers.add(matcher.group().replace("=", "").replace(" ", ""));
            }

            List<String> values;

            input +=",";
            for (Iterator<String> it = headers.iterator(); it.hasNext(); ) {

                String st = it.next()+"";
                pattern = Pattern.compile(st + "=(.*?),");

                matcher = pattern.matcher(input);
                values = new ArrayList<>();
                while (matcher.find()) {

                    values.add(matcher.group().replace(st+"=", "").replace("}", ""));
                }

                table.put(st, values);
            }

            return table;
        }
    }
}