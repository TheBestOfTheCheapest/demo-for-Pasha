/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package com.example.demo.controller;


import com.example.demo.domain.SolutionEntity;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;
import com.example.demo.service.dto.ResultDTO;
import com.example.demo.service.dto.SolutionDTO;
import com.example.demo.service.dto.UserDTO;
import com.example.demo.service.mapper.SolutionMapper;
import com.example.demo.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class GreetingsController {

    private final UserService userService;
    private final TaskService taskService;
    private final UserMapper userMapper;
    private final SolutionMapper solutionMapper;
    Integer userId;
    Integer taskId=1;

    @Autowired
    public GreetingsController(UserService userService, TaskService taskService, UserMapper userMapper, SolutionMapper solutionMapper) {

        this.userService = userService;
        this.taskService = taskService;
        this.userMapper = userMapper;
        this.solutionMapper = solutionMapper;
    }

    @GetMapping("/task")
    public String task(Integer userId, SolutionDTO solution, Model model) {
        model.addAttribute("task", taskService.findTaskById(taskId));

        return "task";
    }

    @PostMapping("/task")
    public String solution(@Valid SolutionDTO solution,  Model model) {
        model.addAttribute("task", taskService.findTaskById(taskId));
        model.addAttribute("solutionValue", solution);
        solution.setTaskId(1);
        ResultDTO result = taskService.getResult(solutionMapper.toEntity(solution));


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

        return "redirect:/task";

    }
}