/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package com.example.demo.service;

import com.example.demo.domain.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.core.SqlResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepo;

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
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
//        try {
//            SqlResolver sqlResolver = new SqlResolver();
//            sqlResolver.createSchema(user.getEmail().replace("@", "").replace(".", ""));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return newUser.getId();
    }


}
