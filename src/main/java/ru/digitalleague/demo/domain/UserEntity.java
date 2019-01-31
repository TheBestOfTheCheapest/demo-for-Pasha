/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package ru.digitalleague.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "first_name")
    @NotNull
    @Size(max = 64)
    private String firstName;

    @Column(name = "middle_name")
    @Size (max = 64)
    private String middleName;

    @Column(name = "last_name")
    @NotNull
    @Size(max = 64)
    private String lastName;

    @Column(name = "email")
    @NotNull
    @Email
    @Size(max = 64)
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<SolutionEntity> solutions;

    public UserEntity() {
    }

    public UserEntity(LocalDateTime createdDate, LocalDateTime updatedDate, @NotNull @Max(value = 64) String firstName, @Max(value = 64) String middleName, @NotNull @Max(value = 64) String lastName, @NotNull @Max(value = 64) String email, String password) {
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SolutionEntity> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<SolutionEntity> solutions) {
        this.solutions = solutions;
    }

    public void addSolution(SolutionEntity solution) {
        if (solutions == null) {
            solutions = new ArrayList<>();
        }

        solutions.add(solution);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}