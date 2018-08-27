/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2018.
 */

package com.example.demo.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "solution")
public class SolutionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "created_date")
    private LocalDateTime createdTime;

    @Column(name = "value")
    private String solutionValue;

    @Column(name = "test_result")
    private Boolean testResult;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity user;

//    @ManyToMany
//    @JoinColumn(name = "task_id")
//    private List<TaskEntity> tasks = new ArrayList<>();


    /* LEGACY */
//    private int taskId;
//    private String solutionId;
    /*END LEGACY*/

    public SolutionEntity() {

    }

//    public SolutionEntity(int taskId, String solutionId, String solutionValue) {
//        this.taskId = taskId;
//        this.solutionId = solutionId;
//        this.solutionValue = solutionValue;
//    }

    public SolutionEntity(LocalDateTime createdTime, String solutionValue, Boolean testResult) {
        this.createdTime = createdTime;
        this.solutionValue = solutionValue;
        this.testResult = testResult;
    }

//    public int getTaskId() {
//        return taskId;
//    }
//
//    public void setTaskId(int taskId) {
//        this.taskId = taskId;
//    }
//
//    public String getSolutionId() {
//        return solutionId;
//    }
//
//    public void setSolutionId(String solutionId) {
//        this.solutionId = solutionId;
//    }

    public String getSolutionValue() {
        return solutionValue;
    }

    public void setSolutionValue(String solutionValue) {
        this.solutionValue = solutionValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

//    public List<TaskEntity> getTasks() {
//        return tasks;
//    }
//
//    public void setTasks(List<TaskEntity> tasks) {
//        this.tasks = tasks;
//    }


    @Override
    public String toString() {
        return "SolutionEntity{" +
                "id=" + id +
                ", createdTime=" + createdTime +
                ", solutionValue='" + solutionValue + '\'' +
                ", testResult=" + testResult +
                ", user=" + user +
                '}';
    }
}