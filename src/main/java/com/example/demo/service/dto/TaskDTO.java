package com.example.demo.service.dto;

import com.example.demo.domain.TaskEntity;

public class TaskDTO {
    private Integer taskId;
    private String taskTitle;
    private String taskText;
    private String sourceSample;

    public TaskDTO() {

    }

    public TaskDTO(TaskEntity task) {
        this.taskId = task.getTaskId();
        this.taskTitle = task.getTaskTitle();
        this.taskText = task.getTaskText();
        this.sourceSample = task.getSourceSample();
    }


    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public String getSourceSample() {
        return sourceSample;
    }

    public void setSourceSample(String sourceSample) {
        this.sourceSample = sourceSample;
    }
}
