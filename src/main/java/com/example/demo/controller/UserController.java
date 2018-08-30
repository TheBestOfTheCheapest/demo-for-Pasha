/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2018.
 */

package com.example.demo.controller;

import com.example.demo.service.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping
    public ResponseEntity<UserDTO> logIn(@RequestBody UserDTO userDto){


        throw new UnsupportedOperationException();
    }

}
