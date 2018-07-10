package com.example.demo.domain;

import javax.persistence.*;

@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;
    private String taskTitle;
    private String taskText;
    private String sourceSample;

    public TaskEntity(){

    }

    public TaskEntity(String taskTitle, String taskText, String sourceSample) {
        this.taskTitle = taskTitle;
        this.taskText = taskText;
        this.sourceSample = sourceSample;
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
