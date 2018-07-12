package com.example.demo.domain;

public class SolutionEntity {
    private int taskId;
    private String solutionId;
    private String solution;

    public SolutionEntity() {
    }

    public SolutionEntity(int taskId, String solutionId, String solution) {
        this.taskId = taskId;
        this.solutionId = solutionId;
        this.solution = solution;
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

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
