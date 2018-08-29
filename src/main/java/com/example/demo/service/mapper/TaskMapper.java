/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2018.
 */

package com.example.demo.service.mapper;

import com.example.demo.domain.TaskEntity;
import com.example.demo.service.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskMapper implements EntityMapper<TaskDTO, TaskEntity> {

    @Override
    public TaskEntity toEntity(TaskDTO dto) {
        if (dto == null) {
            return null;
        }
        TaskEntity task = new TaskEntity();
        task.setTaskId(dto.getTaskId());
        task.setTaskTitle(dto.getTaskTitle());
        task.setTaskText(dto.getTaskText());

        return task;
    }

    @Override
    public TaskDTO toDto(TaskEntity entity) {
        return new TaskDTO(entity);
    }

    @Override
    public List<TaskEntity> toEntity(List<TaskDTO> dtoList) {
        return null;
    }

    @Override
    public List<TaskDTO> toDto(List<TaskEntity> entityList) {
        return null;
    }
}
