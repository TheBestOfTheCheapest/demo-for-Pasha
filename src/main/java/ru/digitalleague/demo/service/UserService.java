/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package ru.digitalleague.demo.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.digitalleague.demo.domain.UserEntity;
import ru.digitalleague.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.demo.service.dto.UserDTO;
import ru.digitalleague.demo.service.mapper.UserMapper;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepo;

    private final UserMapper userMapper;

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    public Integer auth(UserEntity user){
        if(userRepo.existsByEmail(user.getEmail())){
            log.info("User with email {} is already exist and was retrieved", user.getEmail());
            return userRepo.findByEmail(user.getEmail()).getId();
        }
        return createNewUser(user);
    }

    private Integer createNewUser(UserEntity user) {
        user.setCreatedDate(LocalDateTime.now());
        UserEntity newUser = userRepo.save(user);
        log.info("New user was created");

        return newUser.getId();
    }


    public UserEntity registerUser(UserDTO user) {
        UserEntity newUser = userMapper.toEntity(user);

        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getFirstName()));
        return userRepo.save(newUser);


    }
}
