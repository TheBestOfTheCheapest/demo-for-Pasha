/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2018.
 */

package com.example.demo.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "solution")
public class SolutionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_date")
    private LocalDateTime createdTime;

    @Column(name = "value")
    private String solutionValue;

    @Column(name = "test_result")
    private Boolean testResult;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEntity task;

    public SolutionEntity() {

    }

    public SolutionEntity(LocalDateTime createdTime, String solutionValue, Boolean testResult) {
        this.createdTime = createdTime;
        this.solutionValue = solutionValue;
        this.testResult = testResult;
    }

    public String getSolutionValue() {
        return solutionValue;
    }

    public void setSolutionValue(String solutionValue) {
        this.solutionValue = solutionValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Boolean getTestResult() {
        return testResult;
    }

    public void setTestResult(Boolean testResult) {
        this.testResult = testResult;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public TaskEntity getTask() {
        return task;
    }

    public void setTask(TaskEntity task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "SolutionEntity{" +
                "id=" + id +
                ", createdTime=" + createdTime +
                ", solutionValue='" + solutionValue + '\'' +
                ", testResult=" + testResult +
                ", user=" + user +
                ", task=" + task +
                '}';
    }
}