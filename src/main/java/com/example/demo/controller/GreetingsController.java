package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GreetingsController {

    @GetMapping("/")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World")
                                       String name, Map<String,Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @PostMapping("/")
    public String readCode(@RequestParam(name = "code", required = false) String code, Map<String,Object> model) {
        model.put("name","SUCCES");
        return "greeting";
    }
}