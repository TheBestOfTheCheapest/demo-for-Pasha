/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2018.
 */

package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer taskId;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "task_title")
    private String taskTitle;

    @Column(name = "task_text")
    private String taskText;

    @Column(name = "source_sample")
    private String sourceSample;

    @Column(name = "source_template")
    private String sourceTemplate;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private SectionEntity sectionEntity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private List<SolutionEntity> solutions;

    public TaskEntity() {

    }

    public TaskEntity(Integer taskId) {
        this.taskId = taskId;
    }

    public TaskEntity(String taskTitle, String taskText, String sourceSample) {
        this.taskTitle = taskTitle;
        this.taskText = taskText;
        this.sourceSample = sourceSample;
    }

    public TaskEntity(LocalDateTime createdDate, LocalDateTime updatedDate, String taskTitle, String taskText, String sourceSample, String sourceTemplate) {
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.taskTitle = taskTitle;
        this.taskText = taskText;
        this.sourceSample = sourceSample;
        this.sourceTemplate = sourceTemplate;
    }

    public Integer getTaskId() {
        return this.taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
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

    public String getSourceTemplate() {
        return sourceTemplate;
    }

    public void setSourceTemplate(String sourceTemplate) {
        this.sourceTemplate = sourceTemplate;
    }

    public SectionEntity getSectionEntity() {
        return sectionEntity;
    }

    public void setSectionEntity(SectionEntity sectionEntity) {
        this.sectionEntity = sectionEntity;
    }

    public List<SolutionEntity> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<SolutionEntity> solutions) {
        this.solutions = solutions;
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "taskId=" + taskId +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", taskTitle='" + taskTitle + '\'' +
                ", taskText='" + taskText + '\'' +
                ", sourceSample='" + sourceSample + '\'' +
                ", sourceTemplate='" + sourceTemplate + '\'' +
                '}';
    }

}