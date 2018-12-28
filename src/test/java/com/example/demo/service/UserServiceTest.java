/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2018.
 */

package com.example.demo.service;

import com.example.demo.domain.UserEntity;
import com.example.demo.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepo;

    private UserEntity user;

    @Before
    public void setUp() {
        user = new UserEntity();
        user.setId(1);
        user.setFirstName("Jack");
        user.setLastName("Daniels");
        user.setEmail("jack@daniels.com");
    }

    @Test
    public void auth() {
        Mockito.doReturn(true)
                .when(userRepo)
                .existsByEmail(user.getEmail());
        Mockito.doReturn(user)
                .when(userRepo)
                .findByEmail(user.getEmail());
        Mockito.doReturn(user)
                .when(userRepo)
                .findById(user.getId());

        Integer actual = userService.auth(user);
        Assert.assertEquals(new Integer(1), actual);
    }

    @Test
    public void createUser() {
        Mockito.doReturn(false)
                .when(userRepo)
                .existsByEmail(user.getEmail());
        Mockito.doReturn(user)
                .when(userRepo)
                .save(user);

        Integer id = userService.auth(user);
        Mockito.verify(userRepo, Mockito.times(1)).save(user);
        Assert.assertEquals(new Integer(1), id);
    }
}