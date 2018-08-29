/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2018.
 */

package com.example.demo.service.mapper;

import com.example.demo.domain.TaskEntity;
import com.example.demo.service.dto.TaskDTO;
import org.springframework.stereotype.Service;

@Service
public class TaskMapper {

    public TaskDTO taskToTaskDTO(TaskEntity task) {
        return new TaskDTO(task);
    }

    public TaskEntity taskDTOToTask(TaskDTO taskDTO) {
        if (taskDTO == null) {
            return null;
        }
        TaskEntity task = new TaskEntity();
        task.setTaskId(taskDTO.getTaskId());
        task.setTaskTitle(taskDTO.getTaskTitle());
        task.setTaskText(taskDTO.getTaskText());

        return task;

    }
}
