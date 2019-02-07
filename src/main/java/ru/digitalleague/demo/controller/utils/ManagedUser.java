/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package ru.digitalleague.demo.controller.utils;

import ru.digitalleague.demo.domain.UserEntity;
import ru.digitalleague.demo.service.dto.UserDTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class ManagedUser extends UserDTO {

    public static final int PASSWORD_MIN_LENGTH = 4;
    public static final int PASSWORD_MAX_LENGTH = 64;


    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    public ManagedUser() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ManagedUser{" +
                "password='" + password + '\'' +
                '}';
    }
}
