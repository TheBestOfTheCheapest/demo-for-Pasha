package com.example.demo.service.dto;

import java.util.List;

public class TasksDTO {
    private List<TaskDTO> tasks;

    public TasksDTO() {
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }
}
