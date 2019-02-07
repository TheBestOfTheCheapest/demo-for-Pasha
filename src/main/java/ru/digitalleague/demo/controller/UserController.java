/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package ru.digitalleague.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.digitalleague.demo.controller.exceptions.InvalidPasswordException;
import ru.digitalleague.demo.controller.utils.ManagedUser;
import ru.digitalleague.demo.domain.UserEntity;
import ru.digitalleague.demo.service.UserService;
import ru.digitalleague.demo.service.dto.UserDTO;
import ru.digitalleague.demo.service.mapper.UserMapper;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }


    @Deprecated
    @PostMapping("/auth")
    public ResponseEntity<String> logIn(@RequestBody UserDTO userDto) {
        Integer userId = userService.auth(userMapper.toEntity(userDto));
        log.info("User id was retrieved");
        return new ResponseEntity<>("\"userId\" : " + userId, HttpStatus.FOUND);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@Valid @RequestBody ManagedUser user) {
        if (!passwordCheacker(user.getPassword()))
            throw new InvalidPasswordException();

        UserEntity newUser = userService.registerUser(user, user.getPassword());
        log.info("User {} was created", newUser.getEmail());
    }

    private boolean passwordCheacker(String password) {
        return password.length() >= ManagedUser.PASSWORD_MIN_LENGTH &&
                password.length() <= ManagedUser.PASSWORD_MAX_LENGTH;
    }

}
