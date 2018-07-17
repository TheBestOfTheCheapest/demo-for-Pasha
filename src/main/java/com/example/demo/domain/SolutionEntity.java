package com.example.demo.domain;

public class SolutionEntity {
    private int taskId;
    private String solutionId;
    private String solutionValue;

    public SolutionEntity() {
    }

    public SolutionEntity(int taskId, String solutionId, String solutionValue) {
        this.taskId = taskId;
        this.solutionId = solutionId;
        this.solutionValue = solutionValue;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(String solutionId) {
        this.solutionId = solutionId;
    }

    public String getSolutionValue() {
        return solutionValue;
    }

    public void setSolutionValue(String solutionValue) {
        this.solutionValue = solutionValue;
    }
}
