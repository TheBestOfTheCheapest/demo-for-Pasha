package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
