/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package ru.digitalleague.demo.service.dto;

import ru.digitalleague.demo.domain.SolutionEntity;

public class SolutionDTO {
    private Integer id;
    private Integer taskId;
    private Integer userId;
    private String solutionValue;
    private String testResult;

    public SolutionDTO() {
    }

    public SolutionDTO(SolutionEntity solution) {
        this.id = solution.getId();
        this.solutionValue = solution.getSolutionValue();
        this.testResult = solution.getTestResult();
        this.taskId = solution.getTask().getTaskId();
        this.userId = solution.getUser().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSolutionValue() {
        return solutionValue;
    }

    public void setSolutionValue(String solutionValue) {
        this.solutionValue = solutionValue;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
}
