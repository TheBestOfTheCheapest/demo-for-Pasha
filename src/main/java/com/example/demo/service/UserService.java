/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2018.
 */

package com.example.demo.service;

import com.example.demo.domain.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    public final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    private UserEntity createUser(UserEntity user){

        return user;
    }
}
