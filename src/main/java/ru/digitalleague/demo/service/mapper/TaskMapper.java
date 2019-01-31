/*
 * Developed by Andrey Yelmanov
 * Copyright (c) 2019.
 */

package ru.digitalleague.demo.service.mapper;

import ru.digitalleague.demo.domain.TaskEntity;
import ru.digitalleague.demo.service.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TaskDTO> toDto(List<TaskEntity> entityList) {
        return entityList.stream()
                .filter(Objects::nonNull)
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
