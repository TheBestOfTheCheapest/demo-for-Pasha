/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package ru.digitalleague.demo.service.dto;

import ru.digitalleague.demo.domain.AuthorityEntity;
import ru.digitalleague.demo.domain.UserEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO {

    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private Set<String> authorities;

    public UserDTO() {
    }

    public UserDTO (UserEntity user){
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.middleName = user.getMiddleName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.authorities = user.getAuthorities().stream()
                .map(AuthorityEntity::getName)
                .collect(Collectors.toSet());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
